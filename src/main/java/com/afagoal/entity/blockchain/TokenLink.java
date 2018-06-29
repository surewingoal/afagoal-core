package com.afagoal.entity.blockchain;

import com.afagoal.entity.UuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "bc_token_id")
    private String tokenId;

    private String linkType;

    private String linkValue;

}
