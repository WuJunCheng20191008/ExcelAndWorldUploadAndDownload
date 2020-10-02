package org.imooc.dto;

import org.imooc.entity.StudentVo;

import java.util.List;

public class ImportExcelResult {
    private String title;
    private List<StudentVo> studentVoList;
    private String msg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudentVo> getStudentVoList() {
        return studentVoList;
    }

    public void setStudentVoList(List<StudentVo> studentVoList) {
        this.studentVoList = studentVoList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
