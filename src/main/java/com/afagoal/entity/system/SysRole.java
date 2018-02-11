package com.afagoal.entity.system;

import com.afagoal.entity.IdEntity;
import com.afagoal.entity.UuidEntity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import static com.afagoal.entity.QIdEntity.idEntity;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_role")
@Getter
@Setter
public class SysRole extends IdEntity {
    private String roleName;

    private String introduce;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_function",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "function_id")}
    )
    private List<SysFunction> functions;
}