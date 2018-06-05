package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/5/27.
 * Description:
 */
@Entity
@Table(name = "bc_token_ext")
@Getter
@Setter
public class TokenExt extends UuidEntity {

    @Column(name = "bc_token_id")
    private String tokenId;

    private Long holders;

    private Long transfers;

    private BigDecimal highestPrice;

    private BigDecimal lowestPrice;

    private Long highestTransaction;

    private Long lowestTransaction;

    private BigDecimal totalSupply;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_token_id",updatable = false,insertable = false)
    private Token token;

}
