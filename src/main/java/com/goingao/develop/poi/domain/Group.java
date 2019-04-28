package com.goingao.develop.poi.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-26
 */
public class Group implements Serializable {
    @Excel(name = "group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
