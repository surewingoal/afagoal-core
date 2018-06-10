package com.afagoal.entity.blockchain.valueWatch;

import com.afagoal.entity.UuidEntity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Table(name = "bc_value_watcher_condition")
@Getter
@Setter
@Entity
public class ValueWatcherCondition extends UuidEntity {

    private String watchUnit;

    private Integer watchDays;

    private Integer compareTimes;

    private Byte watchType;

    private BigDecimal changeRank;

}
