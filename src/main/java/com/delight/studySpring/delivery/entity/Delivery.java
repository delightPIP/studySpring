package com.delight.studySpring.delivery.entity;

import com.delight.studySpring.base.data.Address;
import com.delight.studySpring.base.entity.BaseEntity;
import com.delight.studySpring.delivery.constant.DeliveryStatus;
import com.delight.studySpring.order.entity.Order;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Delivery extends BaseEntity {

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(STRING)
    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddressAndStatus(Address address, DeliveryStatus status) {
        this.address = address;
        this.status = status;
    }
}