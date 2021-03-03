package com.kcs.starter.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "bids")
@Getter
public class Bids {
    @Id
    @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private String id;

    @Setter
    @NotNull
    @JsonProperty("ProductId")
    @Column(name = "product_id")
    private String productId;

    @Setter
    @NotNull
    @JsonProperty("BidPrice")
    @Column(name = "bid_price")
    private BigDecimal bidPrice;

    @Setter
    @NotNull
    @Column(name = "bid_time")
    private LocalDateTime bidTime = LocalDateTime.now();

    @Setter
    @NotNull
    @JsonProperty("Email")
    @Column(name = "buyer_email")
    private String buyerEmail;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("productId", productId).add("bidTime", bidTime)
                .add("bidPrice", bidPrice).add("buyerEmail", "REMOVED").toString();
    }
}
