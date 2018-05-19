package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;

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
 * Description:币种官网连接表
 */
@Table(name = "bc_token_link")
@Entity
@Getter
@Setter
public class TokenLink extends UuidEntity {

    @Column(name = "bc_token_name")
    private String tokenName;

    @Column(name = "bc_token_code")
    private String tokenCode;

    @Column(name = "bc_token_id")
    private String tokenId;

    private Byte linkType;

    private String linkValue;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_token_id",updatable = false,insertable = false)
    private Token token;
}
