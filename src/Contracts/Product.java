package Contracts;

public interface Product {

    String getName();
    void setName(String name);

    double getPrice();
    void setPrice(double price);

     Long getQuantity();
     void setQuantity(Long quantity);

     void decreaseQuantity(int quantityDecreased);

}
