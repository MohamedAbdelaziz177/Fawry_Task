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

    public List<Product> seedData()
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

    private  void seedSimpleProducts()
    {
        products.add(new BasicProduct("Vodafone Recharge Card 20 EGP", 20.0, 100L));
        products.add(new BasicProduct("Netflix 1-Month Token", 120.0, 300L));
        products.add(new BasicProduct("Orange Recharge Card 20 EGP", 20.0, 100L));

    }

    private void seedShippableProducts()
    {
        Product product1 = new BasicProduct("Smart TV", 8500.0, 10L);
        product1 = new ShippableDecorator(product1, 10.0);

        Product product2 = new BasicProduct("Laptop", 8500.0, 100L);
        product2 = new ShippableDecorator(product2, 10.0);


        Product product3 = new BasicProduct("Desk", 250.0, 200L);
        product3 = new ShippableDecorator(product3, 2.0);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    private void seedExpirableProducts()
    {
        Product cheese = new BasicProduct("Cheddar Cheese 100g", 120.0, 25L);
        cheese = new ExpirableDecorator(cheese, LocalDate.now().plusDays(10));

        Product yogurt = new BasicProduct("Nestle 500g", 30, 25L);
        yogurt = new ExpirableDecorator(yogurt, LocalDate.now().plusDays(10));

        products.add(cheese);
        products.add(yogurt);
    }

    private void seedExpirableAndShippableProducts()
    {
        Product meat = new BasicProduct("Meat", 1200.0, 100L);
        meat = new ExpirableDecorator(meat, LocalDate.now().plusDays(100));
        meat = new ShippableDecorator(meat, 10.0);

        products.add(meat);
    }
}
