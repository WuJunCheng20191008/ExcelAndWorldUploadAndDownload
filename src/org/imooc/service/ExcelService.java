package org.imooc.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.imooc.dto.ImportExcelParam;
import org.imooc.dto.ImportExcelResult;
import org.imooc.entity.StudentVo;
import org.imooc.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ExcelService {
    public ImportExcelResult imp(ImportExcelParam importExcelParam) {
        ImportExcelResult result = new ImportExcelResult();
        List<StudentVo> studentVoList = new ArrayList<>();
        result.setStudentVoList(studentVoList);
        result.setTitle(importExcelParam.getTitle());
        //实现保存
        String fileName = null;
        try {
            fileName = FileUtil.save(importExcelParam.getFileItem(), FileUtil.SAVE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("保存上传文件失败");
        }
        //实现解析
        if (fileName != null) {
            Workbook workbook = null;
            try {
                // 创建之后会一直占用文件不释放，需要手动释放
                //不存储文件 直接获取输入流
                workbook = WorkbookFactory.create(importExcelParam.getFileItem().getInputStream());
                //通过存储文件
//                workbook = WorkbookFactory.create(new File(FileUtil.SAVE_PATH + fileName));
//            workbook.getSheet(""); 通过名称获取
                Sheet sheet = workbook.getSheetAt(0);
                int rowNum = sheet.getLastRowNum();
                for (int i = 1; i <= rowNum; i++) {
                    Row row = sheet.getRow(i);
                    StudentVo studentVo = new StudentVo();
                    studentVo.setName(row.getCell(0).getStringCellValue());
                    studentVo.setAge((int) row.getCell(1).getNumericCellValue());
                    studentVo.setDate(row.getCell(2).getDateCellValue());
                    studentVoList.add(studentVo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.setMsg("解析上传文件失败");
            } finally {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    result.setMsg("释放上传文件失败");
                }
            }
        }
        return result;
    }
    public Workbook export(Boolean isXlsx){
        Workbook workbook;
        if(isXlsx){
            // 07version
            workbook=new XSSFWorkbook();
        }else{
            // 03 version
            workbook=new HSSFWorkbook();
        }
        Sheet mydata = workbook.createSheet("mydata");
        List<List<String>> content = this.getContent();
        for(int i=0;i<content.size();i++){
            Row row=mydata.createRow(i);
            List<String> rowData = content.get(i);
            for(int j=0;j<rowData.size();j++){
                row.createCell(j).setCellValue(rowData.get(j));
            }
        }
        return workbook;
    }

    /**
     * 获取数据
     * @return
     */
    public List<List<String>> getContent(){
        List<List<String>> result=new ArrayList<>();
        List<String> row=new ArrayList<>();
        row.add("序号");
        row.add("姓名");
        row.add("年龄");
        row.add("时间");
        result.add(row);
        List<String> row1 =new ArrayList<>();
        row1.add("1");
        row1.add("demon");
        row1.add("18");
        row1.add("2020-10-01");
        result.add(row1);
        List<String> row2 =new ArrayList<>();
        row2.add("2");
        row2.add("demon2");
        row2.add("28");
        row2.add("2020-10-02");
        result.add(row2);
        List<String> row3 =new ArrayList<>();
        row3.add("3");
        row3.add("demon3");
        row3.add("38");
        row3.add("2020-10-03");
        result.add(row3);
        return result;
    }
}
