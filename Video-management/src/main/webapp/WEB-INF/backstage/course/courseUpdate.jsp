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

<title>修改课程</title>
</head>

<body>


<form action="updateCourse">
 <input type="hidden" name="id" value="${course.id}">
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">标题</label>
      <input type="text" name="course_title" value="${course.course_title}">
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
	   <textarea style="width: 800px;height: 80px;" name="course_desc">${course.course_desc}</textarea>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
			<select name="subject_id" >
					<c:forEach items="${list }" var="list">
	    				<option >${list.subject_id }</option>
	  				</c:forEach>
	 	 		</select>
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