<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

SpringMVC普通上传
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="SpringMVC普通上传"/>
</form>

富文本中的图片上传
<form name="form1" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="富文本图片上传"/>
</form>
</body>
</html>
