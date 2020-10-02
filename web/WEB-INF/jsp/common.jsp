<%
    //协议名称：//服务名：端口号+项目路径
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    request.setAttribute("basePath",basePath);
%>