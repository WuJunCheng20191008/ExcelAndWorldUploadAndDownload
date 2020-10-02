package org.imooc.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imooc.dto.ImportExcelParam;
import org.imooc.dto.ImportExcelResult;
import org.imooc.dto.ParamDto;
import org.imooc.service.ExcelService;
import org.imooc.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImportExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            //上传文件
            ParamDto paramDto = RequestUtil.parseParam(req);
            //把数据再封装到更具体的对象
            ImportExcelParam importExcelParam = new ImportExcelParam();
            importExcelParam.setTitle(paramDto.getParamMap().get("title"));
            importExcelParam.setFileItem(paramDto.getFileMap().get("excel"));
            ExcelService excelService = new ExcelService();
            //保存上传的文件，并解析excel
            ImportExcelResult result = excelService.imp(importExcelParam);
            req.setAttribute("result",result);
        } else {
            //普通表单
            req.getParameter("title");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/importExcelResult.jsp").forward(req, resp);
    }
}
