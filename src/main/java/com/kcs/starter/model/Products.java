package com.kcs.starter.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Products {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @Setter
    @NotNull
    @JsonProperty("Name")
    private String name;

    @Setter
    @NotNull
    @JsonProperty("Details")
    private String details;

    @Setter
    @NotNull
    @Column(name = "bidding_last_date")
    @JsonProperty("BiddingLastDate")
    private LocalDateTime biddingLastDate;

    @Setter
    @NotNull
    @JsonProperty("Price")
    private BigDecimal price;

    @Setter
    @NotNull
    @JsonProperty("Email")
    private String email;

    @Setter
    @NotNull
    private boolean sellStatus = false;

    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("details", details)
                .add("biddingLastDate", biddingLastDate).add("price", price).add("email", "<REMOVED>")
                .add("sellStatus", sellStatus).toString();
    }
}
