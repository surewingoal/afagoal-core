package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;

import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/5/19.
 * Description:虚拟货币表
 */
@Entity
@Table(name = "bc_token")
@Getter
@Setter
public class Token extends UuidEntity {

    private String tokenName;

    private String tokenCode;

    private Byte decimals;

    private String country;

    private LocalDate icoStartDate;

    private LocalDate icoEndDate;

    private String icoPrice;

    private BigDecimal totalCap;

    private BigDecimal totalRaised;

    private Byte weight;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "token")
    @Where(clause = "state <> 99")
    private Collection<TokenLink> tokenLinks;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "token")
    @Where(clause = "state <> 99")
    private TokenExt tokenExt;

}
