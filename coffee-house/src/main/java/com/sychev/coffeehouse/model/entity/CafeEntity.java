package com.sychev.coffeehouse.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cafe", schema = "coffeehouse")
public class CafeEntity {

    private Integer id;
    private UUID uidCafe = UUID.randomUUID();
    private Double latitude;
    private Double longitude;
    private String name;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Type(type = "pg-uuid")
    @Column(name = "cafe_uid")
    public UUID getUidCafe() {
        return uidCafe;
    }

    public void setUidCafe(UUID uidCafe) {
        this.uidCafe = uidCafe;
    }

    @Basic
    @Column(name="latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name="longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
    @Column(name = "description", length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CafeEntity copy (CafeEntity entity) {
        this.setName(entity.getName());
        this.setUidCafe(entity.getUidCafe());
        this.setDescription(entity.getDescription());
        this.setLatitude(entity.getLatitude());
        this.setLongitude(entity.getLongitude());
        this.setId(entity.getId());
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
