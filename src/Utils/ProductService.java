package Utils;

import Contracts.Product;
import Decorators.ExpirableDecorator;
import Decorators.ShippableDecorator;
import Model.BasicProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static List<Product> products = new ArrayList<>();

    public static List<Product> seedData()
    {
        seedSimpleProducts();
        seedExpirableProducts();
        seedShippableProducts();
        seedExpirableAndShippableProducts();

        return products;
    }


    public static Product getByName(String name) {

        return products.stream()
                        .filter(product -> product.getName().equals(name)).findFirst().orElse(null);
    }

    private static  void seedSimpleProducts()
    {
        products.add(new BasicProduct("Vodafone Recharge Card 20 EGP", 20.0, 100L));
        products.add(new BasicProduct("Netflix 1-Month Token", 120.0, 300L));
        products.add(new BasicProduct("Orange Recharge Card 20 EGP", 20.0, 100L));

    }

    private static void seedShippableProducts()
    {
        Product TV = new BasicProduct("Smart TV", 8500.0, 10L);
        TV = new ShippableDecorator(TV, 10.0);

        Product Laptop = new BasicProduct("Laptop", 8500.0, 100L);
        Laptop = new ShippableDecorator(Laptop, 10.0);


        Product Desk = new BasicProduct("Desk", 250.0, 200L);
        Desk = new ShippableDecorator(Desk, 2.0);

        products.add(TV);
        products.add(Laptop);
        products.add(Desk);
    }

    private static void seedExpirableProducts()
    {
        Product cheese = new BasicProduct("Cheddar Cheese 100g", 120.0, 25L);
        cheese = new ExpirableDecorator(cheese, LocalDate.now().plusDays(10));

        Product yogurt = new BasicProduct("Nestle 500g", 30, 25L);
        yogurt = new ExpirableDecorator(yogurt, LocalDate.now().plusDays(-2));

        products.add(cheese);
        products.add(yogurt);
    }

    private static void seedExpirableAndShippableProducts()
    {
        Product meat = new BasicProduct("Meat", 1200.0, 100L);
        meat = new ExpirableDecorator(meat, LocalDate.now().plusDays(100));
        meat = new ShippableDecorator(meat, 10.0);

        products.add(meat);
    }
}
