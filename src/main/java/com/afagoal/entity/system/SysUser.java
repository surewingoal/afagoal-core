package com.afagoal.entity.system;

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

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class SysUser extends UuidEntity{
    private String userName;

    private String nickName;

    private String realName;

    private String password;

    private String loginIp;

    private int loginTimes;

    private String email;

    private String mobile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "sys_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<SysRole> roles;
}
