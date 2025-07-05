import Contracts.Product;
import Model.Cart;
import Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        // It's supposed here to register a new customer .. but for simplicity and testing, we 'll only read the balance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Ur balance: ");
        double balance = scanner.nextDouble();

        List<Product> productsInventory = ProductService.seedData();

        Cart cart = new Cart();

        try {
            cart.addItem("Nestle 500g", 10L);
            cart.addItem("Vodafone Recharge Card 20 EGP", 2L);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try
        {
            List<CheckOutDto> CheckoutDetails = CheckoutService.getCheckoutReceipt(cart);
            Map<String, Double> MoneyDetails = CheckoutService.getCheckoutDetails(CheckoutDetails);


            System.out.println("**************************************");

            System.out.println("Checkout Details");
            for (CheckOutDto checkOutDto : CheckoutDetails) {
                System.out.println(checkOutDto.getProductName() +
                        " - " + checkOutDto.getQuantity() + " - " + checkOutDto.getTotalPrice() + "EGP");

            }

            System.out.println("------------------");
            for(Map.Entry<String, Double> entry : MoneyDetails.entrySet())
            {
                System.out.println(entry.getKey() + " : " + entry.getValue());

                if(entry.getKey().equals("Amount"))
                {
                    if(!CheckoutService.validatePossiblePurchase(entry.getValue(), balance))
                    {
                        System.out.println("You don't have enough balance");
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("**************************************");

        List<ShipmentDto> ShipmentNotice = ShipmentService.getShipmentNotice(cart);

        System.out.println("Shipment Notice: ");
        for (ShipmentDto shipmentDto : ShipmentNotice) {
            System.out.println(shipmentDto.getProductName() +
                    " - " + shipmentDto.getQuantity() + " - " + shipmentDto.getTotalWeight() + "g");

        }



    }
}