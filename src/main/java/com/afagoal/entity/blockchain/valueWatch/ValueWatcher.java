package com.afagoal.entity.blockchain.valueWatch;

import com.afagoal.entity.UuidEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Table(name = "bc_value_watcher")
@Getter
@Setter
@Entity
public class ValueWatcher extends UuidEntity {

    @Column(name = "bc_token_id")
    private String tokenId;

    private String address;

    private BigDecimal todayValue;

    private LocalDate today;

    private BigDecimal triggerValue;

    private LocalDate triggerDate;

    private Byte changeSign;

    @Column(name = "bc_watch_condition_id")
    private String watchConditionId;

    private String remindInfo;
}
