<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>

	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>修改视频信息</h2>
		</div>
	</div>
	
<form action="videoP" method="post" enctype="multipart/form-data">
	<!-- 隐藏数据 -->
	<input  type="hidden" name="video_id" value="${video.video_id}">
	<input type="hidden" name="image_url" value="${video.image_url}">	
	<input type="hidden" name="video_url" value="${video.video_url}">
	
	
	
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频标题</label>
      <input type="text" name="title" value="${video.title}">
  	</div>
  	
  	
  	
  	
  	
 	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label> 
    <select name="speaker_id">
				<c:forEach items="${slist }" var="list">
					<option  value="${list.id}">${list.speaker_name }</option>
				</c:forEach>
			</select>
		</div>
  
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
    <select name="course_id" >
			<c:forEach items="${clist }" var="list">
	    		<option value="${list.id}" >${list.course_title}</option>
	  		</c:forEach>
	 	 </select>		
   </div>
  
   
   
   
   
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频时长(秒)</label>
      <input type="text" name="time" value="${video.time}">
  	</div>

   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">备注</label>
      <input type="text" name="detail" value="${video.detail}">
  	</div> 
  	
  	
  	
  	
  	
 	 <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频</label>
      <input  name="MP" onchange="fileSelectHandler()" type="file">
  	</div>
  	 <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">封面</label>
      <input  name="IMG" onchange="fileSelectHandler()" type="file">
  	</div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     				<br><br>
      <button type="submit" class="btn btn-default" >保存</button>
	  <a  class="btn btn-default" href="show">返回</a>
    </div>
  </div>
  
  
   <%--  	<div class="form-group" >
    <label for="inputPassword3" class="col-sm-2 control-label">封面图片地址</label>
      <input type="text" name="image_url" value="${video.image_url}">
  	</div>
  	<div class="form-group" >
    <label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
      <input type="text" name="video_url" value="${video.video_url}">
  	</div> --%>
</form>




   
</body>
</html>