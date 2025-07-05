package Model;

import Contracts.Product;

public class BasicProduct implements Product {

    private String name;
    private double price;
    private Long quantity;

    public BasicProduct(String name, double price, Long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Long getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public void decreaseQuantity(int quantityDecreased) {
        this.quantity = this.quantity - quantityDecreased;
    }
}
