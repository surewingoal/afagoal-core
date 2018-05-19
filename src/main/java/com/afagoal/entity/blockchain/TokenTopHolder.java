package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/5/19.
 * Description:币种持有者排名
 */
@Table(name = "bc_token_top_holder")
@Entity
@Getter
@Setter
public class TokenTopHolder extends UuidEntity {

    private String tokenName;

    private String tokenCode;

    private String tokenId;

    private String address;

    private Byte rank;

    private BigDecimal quantily;

    private BigDecimal percentage;

    private Byte yesterdayRank;

    private BigDecimal yesterdayQuantily;

    private BigDecimal yesterdayPercentage;

    private BigDecimal percentageChange;

    private LocalDateTime statisticTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_token_id",updatable = false,insertable = false)
    private Token token;

}
