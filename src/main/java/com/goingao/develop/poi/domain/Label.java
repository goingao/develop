package com.goingao.develop.poi.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-27
 */
@Data
public class Label implements Serializable {

    private static final long serialVersionUID = -235864909700555168L;

    private String id;

    private String name;

    private Integer type;

    private Integer cycleMonth;

    private Integer logicalType;

    private Integer status;

    private String desc;

    private String companyId;
}
