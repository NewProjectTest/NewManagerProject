<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>修改</title>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


<form action="updateSpeaker" method="post" enctype="multipart/form-data"><br><br><br><br><br><br>
 <c:if test="${speaker.id != null}">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
      <input type="text" name="id" readonly="readonly" value="${speaker.id }">
  </div>
 </c:if>  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">名字</label>
      <input type="text" name="speaker_name" value="${speaker.speaker_name }">
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">经验</label>
	   <textarea style="width: 800px;height: 80px;" name="speaker_desc">${speaker.speaker_desc }</textarea>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">职位</label>
      <input type="text" name="speaker_job" value="${speaker.speaker_job }">
  </div>
  <!-- 照片路径 -->
  <div class="pic_url">
    <label for="inputPassword3" class="col-sm-2 control-label">头像</label>
    	<input type="hidden" value="${speaker.pic_url }" name="pic_url">
    	<input type="file" name="img">
      <%-- <textarea style="width: 200px;height: 80px;" name="pic_url" >${speaker.pic_url }</textarea>
    --%>
  </div>
 
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     				<br><br>
      <button type="submit" class="btn btn-default" >（保存）save</button>
	  <a  class="btn btn-default" href="show">（返回）return</a>
    </div>
  </div>
  
</form>



</body>
</html>