package Utils;

public class ShipmentDto {

    private String productName;
    private Long quantity;
    private double totalWeight;

    public ShipmentDto(String productName, Long quantity, double totalWeight) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalWeight = totalWeight;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
