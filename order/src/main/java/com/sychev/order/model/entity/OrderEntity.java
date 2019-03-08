package com.sychev.order.model.entity;

import com.sychev.order.model.OrderStatus;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "order")
public class OrderEntity {

    private Integer id;
    private UUID orderUid;
    private UUID cafeUid;
    private UUID customerUid;
    private Set<OrderProducts> products = new HashSet<>();
    private Double totalPrice;
    private Instant createDttm;
    private Instant receiveDttm;
    private OrderStatus status;

    public OrderEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Type(type = "pg-uuid")
    @Column(name = "order_uid", nullable = false)
    public UUID getOrderUid() {
        return orderUid;
    }

    public OrderEntity setOrderUid(UUID orderUid) {
        this.orderUid = orderUid;
        return this;
    }

    @Type(type = "pg-uuid")
    @Column(name = "cafe_uid", nullable = false)
    public UUID getCafeUid() {
        return cafeUid;
    }

    public OrderEntity setCafeUid(UUID cafeUid) {
        this.cafeUid = cafeUid;
        return this;
    }

    @Type(type = "pg-uuid")
    @Column(name = "customer_uid", nullable = false)
    public UUID getCustomerUid() {
        return customerUid;
    }

    public OrderEntity setCustomerUid(UUID customerUid) {
        this.customerUid = customerUid;
        return this;
    }

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_uid"))
    @Column(name = "order_products")
    public Set<OrderProducts> getProducts() {
        return products;
    }

    public OrderEntity setProducts(Set<OrderProducts> products) {
        this.products = products;
        return this;
    }

    @Column(name = "price", nullable = false)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderEntity setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Column(name = "create_dttm", nullable = false)
    public Instant getCreateDttm() {
        return createDttm;
    }

    public OrderEntity setCreateDttm(Instant createDttm) {
        this.createDttm = createDttm;
        return this;
    }

    @Column(name = "receive_dttm", nullable = false)
    public Instant getReceiveDttm() {
        return receiveDttm;
    }

    public OrderEntity setReceiveDttm(Instant receiveDttm) {
        this.receiveDttm = receiveDttm;
        return this;
    }

    @Column(name = "status", nullable = false)
    public OrderStatus getStatus() {
        return status;
    }

    public OrderEntity setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderEntity copy(OrderEntity entity) {
        this.setCafeUid(entity.getCafeUid());
        this.setCreateDttm(entity.getCreateDttm());
        this.setCustomerUid(entity.getCustomerUid());
        this.setOrderUid(entity.getOrderUid());
        this.setProducts(entity.getProducts());
        this.setReceiveDttm(entity.getReceiveDttm());
        this.setStatus(entity.getStatus());
        this.setTotalPrice(entity.getTotalPrice());
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
