package Decorators;

import Contracts.Product;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableDecorator extends BasicDecorator {

    private LocalDate expiration;

    public ExpirableDecorator(Product product, LocalDate expiration) {
        super(product);
        this.expiration = expiration;
    }


    public boolean isExpired() {
        return expiration.isBefore(LocalDate.now());
    }

    public LocalDate getExpiration() {
        return expiration;
    }
}
