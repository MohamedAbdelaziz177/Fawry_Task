package Decorators;

import Contracts.Product;

public abstract class BasicDecorator implements Product {

    protected Product product;
    public BasicDecorator(Product product) {
        this.product = product;
    }
    public String getName() {
        return product.getName();
    }

    public void  setName(String name) {
        product.setName(name);
    }

    public double getPrice() {
        return product.getPrice();
    }

    public void setPrice(double price) {
        product.setPrice(price);
    }

    public Long getQuantity() {
        return product.getQuantity();
    }

    public void setQuantity(Long quantity) {
        product.setQuantity(quantity);
    }


    public void decreaseQuantity(int quantity) {
        product.decreaseQuantity(quantity);
    }
}
