package com.goingao.develop.poi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-27
 */
@AllArgsConstructor
@Getter
public enum SysLabelInitialInfoEnum {
    /**
     * 潜在客户
     */
    POTENTIAL_CUSTOMER( "潜在","未到店消费的客户"),
    /**
     * 新客客户
     */
    NEW_CUSTOMER("新客","第一次到店消费的客户"),
    /**
     * 活跃客户
     */
    ACTIVE_CUSTOMER("活跃","最近{0}个月到店消费的客户"),
    /**
     * 流失客户
     */
    LOSS_CUSTOMER("流失","到店消费过，且最近{0}个月内未到店消费的客户"),
    /**
     * 回流客户
     */
    BACK_CUSTOMER("回流","流失后再次到店消费的客户");

    private String name;

    private String desc;
}
