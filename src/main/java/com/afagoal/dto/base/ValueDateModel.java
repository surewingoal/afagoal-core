package com.afagoal.dto.base;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Setter
@Getter
public class ValueDateModel {

    private Number value;

    private LocalDateTime statisticTime;

}
