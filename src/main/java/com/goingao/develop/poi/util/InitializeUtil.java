package com.goingao.develop.poi.util;

import com.goingao.develop.poi.domain.Group;
import com.goingao.develop.poi.domain.SysLabelInitialInfoEnum;
import com.google.common.collect.Lists;

import java.text.MessageFormat;
import java.util.List;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-27
 */
public class InitializeUtil {

    public static List<String> genSysLabel(List<Group> groups) {
        List<String> sqls = Lists.newArrayList();

        for (Group group : groups) {
            for (SysLabelInitialInfoEnum s : SysLabelInitialInfoEnum.values()) {
                String test = MessageFormat.format("INSERT INTO label" +
                                " (name, type, cycle_month, logical_type, status, `desc`, company_id, creationtime, modifiedtime)" +
                                " VALUES (''{0}'', 1, 6, 0, 1, ''{1}'', ''{2}'', now(), now());",
                        s.getName(), s.getDesc(), group.getGroupId());
                sqls.add(test);
            }
        }
        return sqls;
    }
}
