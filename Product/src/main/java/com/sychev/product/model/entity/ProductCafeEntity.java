package com.sychev.product.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_cafe", schema = "supplies")
public class ProductCafeEntity {

    private UUID productUid;
    private UUID cafeUid;

    @Id
    public UUID getProductUid() {
        return productUid;
    }

    public void setProductUid(UUID productUid) {
        this.productUid = productUid;
    }

    @Id
    public UUID getCafeUid() {
        return cafeUid;
    }

    public void setCafeUid(UUID cafeUid) {
        this.cafeUid = cafeUid;
    }

}
