package com.afagoal.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Created by BaoCai on 18/1/6.
 * Description:
 */
@Data
public class BaseDto {

    private String id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    private byte state;
}
