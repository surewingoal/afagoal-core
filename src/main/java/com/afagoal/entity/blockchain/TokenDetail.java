package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/5/19.
 * Description:虚拟币每日详情表
 */
@Table(name = "bc_token_detail")
@Entity
@Setter
@Getter
public class TokenDetail extends UuidEntity {

    @Column(name = "bc_token_name")
    private String tokenName;
    @Column(name = "bc_token_code")
    private String tokenCode;
    @Column(name = "bc_token_id")
    private String tokenId;

    private BigDecimal todayPrice;

    private BigDecimal priceChange;

    private Long volume;

    private LocalDateTime statisticTime;

    private BigDecimal totalValue;

    private BigDecimal usdProfitability;  //usd盈利率

    private BigDecimal usd;

    private BigDecimal ethProfitability;  //eth盈利率

    private BigDecimal eth;

    private BigDecimal circulatingSupply;  //今日流动量

    private Long todayTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_token_id",updatable = false,insertable = false)
    private Token token;

}
