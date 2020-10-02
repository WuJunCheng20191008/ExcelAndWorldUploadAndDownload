package org.imooc.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imooc.dto.ParamDto;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class RequestUtil {
    /**
     * 把request里面的数据封装到对象
     * @param request
     * @return
     */
    public static ParamDto parseParam(HttpServletRequest request){
        ParamDto result=new ParamDto();
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        //通过upload对象解析，获取所有的input类型
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if(fileItem.isFormField()){
                    //普通字段
                    result.getParamMap().put(fileItem.getFieldName(),fileItem.getString("UTF-8"));
                }else {
                    File file=new File(FileUtil.SAVE_PATH);
                    if(!file.exists()){
                        file.mkdir();
                    }
                    result.getFileMap().put(fileItem.getFieldName(),fileItem);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
