package Model;

import Contracts.Product;
import Utils.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Cart {

    List<CartItem> cartItems = new ArrayList<CartItem>();

    public List<CartItem> getItems()
    {
        return cartItems;
    }

    public List<CartItem> addItem(String productName, Long quantity)
    {
        Product product = ProductService.getByName(productName);

        if(product == null)
            throw new NoSuchElementException("No such product found");

        if(product.getQuantity() < quantity)
            throw new IllegalArgumentException("Product quantity is less than the required quantity");

        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);

        return cartItems;
    }

    public List<CartItem> removeItem(String name)
    {
        CartItem item = cartItems.stream()
                .filter(cartItem -> cartItem.getItem().getName().equals(name))
                .findFirst()
                .orElse(null);

        if(item == null)
            throw new NoSuchElementException("No such cart item found");

        cartItems.remove(item);

        return cartItems;
    }
}
