package Model;

import Contracts.Product;

public class CartItem {

    private Product item;
    private Long quantity;

    public CartItem(Product item, Long quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
