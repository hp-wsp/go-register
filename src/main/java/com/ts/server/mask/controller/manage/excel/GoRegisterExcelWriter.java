package com.ts.server.mask.controller.manage.excel;

import com.ts.server.mask.common.excel.HttpExcelWriter;
import com.ts.server.mask.domain.GoRegister;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 写预约到Excel报表中
 *
 * @author TS Group
 */
public class GoRegisterExcelWriter extends HttpExcelWriter<GoRegister> {
    private static final String[] HEADS = new String[]{"姓名", "性别", "身份证号", "手机号", "外出省份",
            "外出城市", "外出县区", "有何技能", "本县地址", "是否在疫区", "是否贫困户", "是否有政府统一安排出务工乘车需求", "外出时间",
            "乡镇", "村组", "登记时间"};

    public GoRegisterExcelWriter(HttpServletResponse response, boolean is2003, String filename) throws IOException {
        super(response, is2003, filename);
    }

    @Override
    protected void writeRow(Row row, GoRegister t) {
        Cell cell = row.createCell(0);
        cell.setCellValue(t.getName());
        cell = row.createCell(1);
        cell.setCellValue(t.getSex());
        cell = row.createCell(2);
        cell.setCellValue(t.getIdCard());
        cell = row.createCell(3);
        cell.setCellValue(t.getMobile());
        cell = row.createCell(4);
        cell.setCellValue(t.getProvince());
        cell = row.createCell(5);
        cell.setCellValue(t.getCity());
        cell = row.createCell(6);
        cell.setCellValue(t.getCounty());
        cell = row.createCell(7);
        cell.setCellValue(t.getSkill() == null? "": t.getSkill());
        cell = row.createCell(8);
        cell.setCellValue(t.getCouAddress());
        cell = row.createCell(9);
        cell.setCellValue(t.isInpArea()? "是": "否");
        cell = row.createCell(10);
        cell.setCellValue(t.isPoverty()? "是": "否");
        cell = row.createCell(11);
        cell.setCellValue(t.isDriver()? "是": "否");
        cell = row.createCell(12);
        cell.setCellValue(t.getGoDate());
        cell = row.createCell(13);
        cell.setCellValue(t.getArea());
        cell = row.createCell(14);
        cell.setCellValue(t.getVillage());
        cell = row.createCell(15);
        LocalDateTime time = LocalDateTime.ofInstant(t.getCreateTime().toInstant(), ZoneId.systemDefault());
        cell.setCellValue(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Override
    protected int writeHeader(Workbook workbook, Sheet sheet) {
        Row row = sheet.createRow(0);
        for(int i = 0; i < HEADS.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(HEADS[i]);
        }
        return 1;
    }
}
