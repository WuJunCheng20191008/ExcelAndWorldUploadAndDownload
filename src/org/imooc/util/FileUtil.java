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
        /*
        * ���FileItem�����е����������Ǳ�����ĳ����ʱ�ļ��У��÷���˳����ɺ���ʱ�ļ��п��ܻᱻ���
        * https://blog.csdn.net/qq_44872773/article/details/106069921
        * */
        fileItem.write(new File(path + fileName));
        return fileName;
    }
}
