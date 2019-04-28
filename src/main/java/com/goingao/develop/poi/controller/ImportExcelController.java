package com.goingao.develop.poi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.goingao.develop.poi.biz.GroupExcelHandler;
import com.goingao.develop.poi.domain.Group;
import com.goingao.develop.poi.domain.Label;
import com.goingao.develop.poi.util.InitializeUtil;
import com.goingao.develop.toolkit.WriteFile;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-26
 */
@RestController
public class ImportExcelController {

    public static void main(String[] args) {
        String filePath = "/Users/goingao/Desktop/tg_org_group_sst.xls";
//        String path = "template/excel/prod.xls";
        if (StringUtils.isBlank(filePath)){
            System.out.println("没有文件");
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Group> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), Group.class, params);
            List<String> sqls = InitializeUtil.genSysLabel(list);

            WriteFile.writeFileContext(sqls,"/Users/goingao/Desktop/sst-sys-label.sql");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
