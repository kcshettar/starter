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
@Table(name = "products")
@Getter
public class Products {
    @Id
    @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private String id;

    @Setter
    @NotNull
    @JsonProperty("Name")
    @Column(name = "name")
    private String name;

    @Setter
    @NotNull
    @JsonProperty("Details")
    @Column(name = "details")
    private String details;

    @Setter
    @NotNull
    @JsonProperty("BiddingLastDate")
    @Column(name = "bidding_last_date")
    private LocalDateTime biddingLastDate;

    @Setter
    @NotNull
    @JsonProperty("MinPrice")
    @Column(name = "min_price")
    private BigDecimal minPrice;

    @Setter
    @NotNull
    @JsonProperty("Email")
    @Column(name = "seller_email")
    private String sellerEmail;

    @Setter
    @NotNull
    @Column(name = "bid_status")
    private boolean bidStatus = false;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("details", details)
                .add("biddingLastDate", biddingLastDate).add("minPrice", minPrice).add("sellerEmail", "<REMOVED>")
                .add("bidStatus", bidStatus).toString();
    }
}
