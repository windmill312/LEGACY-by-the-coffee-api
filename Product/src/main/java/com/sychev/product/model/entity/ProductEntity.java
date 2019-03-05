package com.sychev.product.model.entity;

import com.sychev.product.model.ProductGroup;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product", schema = "supplies")
public class ProductEntity {

    private Integer id;
    private UUID productUid = UUID.randomUUID();
    private String name;
    private String description;
    private Integer price;
    private ProductGroup group;

    public ProductEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public ProductEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Basic
    @Type(type = "pg-uuid")
    @Column(name = "product_uid", nullable = false)
    public UUID getProductUid() {
        return productUid;
    }

    public void setProductUid(UUID productUid) {
        this.productUid = productUid;
    }

    @Basic
    @Column(name = "name", unique = true, nullable = false, length = 60)
    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "description", length = 100)
    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public ProductEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Basic
    @Column(name = "group", nullable = false)
    public ProductGroup getGroup() {
        return group;
    }

    public ProductEntity setGroup(ProductGroup group) {
        this.group = group;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
