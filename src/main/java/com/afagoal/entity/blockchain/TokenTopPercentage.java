package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/4.
 * Description:
 */
@Table(name = "bc_token_top_percentage")
@Getter
@Setter
@Entity
public class TokenTopPercentage extends UuidEntity {

    @Column(name = "bc_token_name")
    private String tokenName;
    @Column(name = "bc_token_id")
    private String tokenId;
    @Column(name = "bc_token_code")
    private String tokenCode;

    private Byte topType;

    private BigDecimal yesterdayPercentage;

    private BigDecimal percentage;

    private LocalDateTime statisticTime;

    private BigDecimal holdNums;

}
