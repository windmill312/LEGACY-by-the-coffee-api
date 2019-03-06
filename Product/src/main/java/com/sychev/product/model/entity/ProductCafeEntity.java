package com.sychev.product.model.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_cafe", schema = "supplies")
public class ProductCafeEntity {

    private Integer id;
    private UUID productUid;
    private UUID cafeUid;
    private ProductEntity product;

    @Primary
    public UUID getProductUid() {
        return productUid;
    }

    public void setProductUid(UUID productUid) {
        this.productUid = productUid;
    }

    @Primary
    public UUID getCafeUid() {
        return cafeUid;
    }

    public void setCafeUid(UUID cafeUid) {
        this.cafeUid = cafeUid;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product", nullable = false)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
