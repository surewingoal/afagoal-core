package com.afagoal.entity.wc;

import com.afagoal.entity.UuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/3.
 * Description:
 */
@Getter
@Setter
@Table(name = "wc_advertisement")
@Entity
public class Advertisement extends UuidEntity {

    private String content;

    private String img_url;

    private String advertise_link;

    private Byte type;
}
