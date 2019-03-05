/*package com.sychev.coffeehouse.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product", schema = "coffeehouse")
public class ProductEntity {

    private Integer id;
    private UUID uidProduct = UUID.randomUUID();
    private String name;
    private String description;
    private Integer price;
    private CafeEntity cafe;

    public ProductEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Type(type = "pg-uuid")
    @Column(name = "question_uid", nullable = false)
    public UUID getUidProduct() {
        return uidProduct;
    }

    public void setUidProduct(UUID uidProduct) {
        this.uidProduct = uidProduct;
    }

    @Basic
    @Column(name = "name", unique = true, nullable = false, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @ManyToOne
    @JoinColumn(name="cafe_uid")
    public CafeEntity getCafe() {
        return cafe;
    }

    public void setCafe(CafeEntity cafe) {
        this.cafe = cafe;
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
}*/
