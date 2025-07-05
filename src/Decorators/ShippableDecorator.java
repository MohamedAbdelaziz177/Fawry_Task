package Decorators;

import Contracts.Product;

public class ShippableDecorator extends BasicDecorator {

    private double weight;
    private double shippingCost;

    public ShippableDecorator(Product product, double weight)
    {
        super(product);
        this.weight = weight;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getShippingCost()
    {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost)
    {
        this.shippingCost = shippingCost;
    }

}
