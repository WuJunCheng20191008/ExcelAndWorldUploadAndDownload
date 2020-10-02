package org.imooc.dto;

import org.apache.commons.fileupload.FileItem;

import java.util.HashMap;
import java.util.Map;

public class ImportExcelParam {
    private String title;
    private FileItem fileItem;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FileItem getFileItem() {
        return fileItem;
    }

    public void setFileItem(FileItem fileItem) {
        this.fileItem = fileItem;
    }
}
