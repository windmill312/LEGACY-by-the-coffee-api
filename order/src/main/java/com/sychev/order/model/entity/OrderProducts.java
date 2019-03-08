package com.sychev.order.model.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Embeddable
public class OrderProducts {

    @NotNull
    private UUID productUid;

    @NotNull
    private Integer quantity;

    public OrderProducts(@NotNull UUID productUid, @NotNull Integer quantity) {
        this.productUid = productUid;
        this.quantity = quantity;
    }

    public OrderProducts() {
    }

    public UUID getProductUid() {
        return productUid;
    }

    public void setProductUid(UUID productUid) {
        this.productUid = productUid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
