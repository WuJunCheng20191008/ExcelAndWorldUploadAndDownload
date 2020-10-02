package org.imooc.util;

import org.apache.commons.fileupload.FileItem;

import java.io.File;

public class FileUtil {
    /**
     * 上传文件保存地址
     */
    public static final String SAVE_PATH = "d:/upload/";

    /**
     * 保存上传文件
     *
     * @param fileItem
     * @param path
     * @return
     */
    public static String save(FileItem fileItem, String path) throws Exception {
        String fileName = System.currentTimeMillis() + "_" + fileItem.getName();
        fileItem.write(new File(path + fileName));
        return fileName;
    }
}
