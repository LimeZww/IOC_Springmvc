<%--
  Created by IntelliJ IDEA.
  User: OY
  Date: 10/15/2019
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Download the page</title>
</head>
<body style="background-color: #b9b4b4">
<div style="margin:auto;width: 400px;height: 200px;padding: 20px;border-radius: 10px;border:10px;background-color: #e4c8ff">
    <h4>点击下载</h4>
    <a href="download?filename=${requestScope.fileInfo.file.originalFilename}">${requestScope.fileInfo.file.originalFilename}</a>
</div>
</body>
</html>
