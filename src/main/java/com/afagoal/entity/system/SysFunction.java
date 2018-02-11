package com.afagoal.entity.system;

import com.afagoal.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_function")
@Getter
@Setter
public class SysFunction extends IdEntity {

    private String functionName;

    private String functionUrl;

    private Integer pid;

    private String introduce;

    private Integer type;

    private String icon;
}
