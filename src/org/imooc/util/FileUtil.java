package org.imooc.util;

import org.apache.commons.fileupload.FileItem;

import java.io.File;

public class FileUtil {
    /**
     * �ϴ��ļ������ַ
     */
    public static final String SAVE_PATH = "d:/upload/";

    /**
     * �����ϴ��ļ�
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
