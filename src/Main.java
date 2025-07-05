import Contracts.Product;
import Model.Cart;
import Model.Customer;
import Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void Test()
    {

        //System.out.println("Enter your name: ");
        //String name = scanner.nextLine();
        //System.out.println("Enter your balance: ");
        //Long balance = scanner.nextLong();
//
        //Customer customer = new Customer(name, balance);
        //for (Product product : productsInventory) {
        //    System.out.println(product.getName());
        //    System.out.println(product.getPrice());
        //    System.out.println(product.getQuantity());
        //    System.out.println("------------------");
        //}


        //while (true)
        //{
        //    System.out.println("Enter product name to add to cart: ");
        //    String productName = scanner.nextLine();
//
        //    while (!scanner.hasNextLong()) {
        //        System.out.println("Invalid quantity! Please enter a whole number:");
        //        scanner.next();  // discard invalid input
        //    }
//
        //    System.out.println("Enter product quantity: ");
        //    Long productQuantity = scanner.nextLong();
        //    scanner.nextLine();
//
        //    try {
        //        cart.addItem(productName, productQuantity);
        //    }
        //    catch (Exception e) {
        //        System.out.println(e.getMessage());
        //    }
//
//
        //    System.out.println("Do you want to add more products to cart? (y/n)");
        //    String answer = scanner.nextLine();
        //    if(answer.equals("n"))
        //        break;
        //}

    }
    public static void main(String[] args) {


        // It's supposed here to register a new customer .. but for simplicity and testing, we 'll only read the balance
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ur balance: ");
        double balance = scanner.nextDouble();

        ProductService productService = new ProductService();

        List<Product> productsInventory = productService.seedData();


        Cart cart = new Cart();

        try {
            cart.addItem("Meat", 10L); // will throw since the quantity
            // is greater than the available quantity

            cart.addItem("Vodafone Recharge Card 20 EGP", 2L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        List<CheckOutDto> CheckoutDetails = CheckoutService.getCheckoutReciept(cart);
        Map<String, Double> MoneyDetails = CheckoutService.getCheckoutDetails(CheckoutDetails);
        List<ShipmentDto> ShipmentNotice = ShipmentService.getShipmentNotice(cart);

        System.out.println("Shipment Notice: ");
        for (ShipmentDto shipmentDto : ShipmentNotice) {
            System.out.println(shipmentDto.getProductName() +
                    " - " + shipmentDto.getQuantity() + " - " + shipmentDto.getTotalWeight() + "g");

        }

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
                    return;
                }
            }
        }

    }
}