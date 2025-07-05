package Utils;

import Model.Cart;
import Model.CartItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutService {

    public static List<CheckOutDto> getCheckoutReciept(Cart cart)
    {
        List<CheckOutDto> checkOutDtoList = new ArrayList<CheckOutDto>();

        List<CartItem> cartItems = cart.getItems();
        double totalPrice = 0;
        for(CartItem cartItem : cartItems)
        {
            checkOutDtoList.add(new CheckOutDto(cartItem.getItem().getName(), cartItem.getQuantity(),
                    cartItem.getItem().getPrice() * cartItem.getQuantity()));
        }

        return checkOutDtoList;
    }

    public static Map<String, Double> getCheckoutDetails(List<CheckOutDto> checkOutDtoList)
    {
        Map<String, Double> checkoutDetails = new HashMap<String, Double>();
        checkoutDetails.put("subtotal", 0D);
        checkoutDetails.put("ShippingFees", 0D);
        checkoutDetails.put("Amount", 0D);

        for(CheckOutDto checkOutDto : checkOutDtoList)
        {
            checkoutDetails.put("subtotal",
                    checkoutDetails.get("subtotal") + checkOutDto.getTotalPrice());

            checkoutDetails.put("ShippingFees",
                    checkoutDetails.get("ShippingFees") + checkOutDto.getTotalPrice() * 0.05);
        }

        checkoutDetails
                .put("Amount", checkoutDetails.get("subtotal") + checkoutDetails.get("ShippingFees"));

        return checkoutDetails;
    }

    public static boolean validatePossiblePurchase(Double amount, double balance)
    {
        return amount <= balance;
    }


}
