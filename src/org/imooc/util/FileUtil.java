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
        /*
        * 如果FileItem对象中的主体内容是保存在某个临时文件中，该方法顺利完成后，临时文件有可能会被清除
        * https://blog.csdn.net/qq_44872773/article/details/106069921
        * */
        fileItem.write(new File(path + fileName));
        return fileName;
    }
}
