<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>courseShow</title>
<script src="js/jquery-1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/confirm.js"></script>
<script src="js/jquery.js"></script>
<script src="js/message_cn.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />

<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
<body>


	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>课程管理</h2>
		</div>
	</div>
	<form action="http://localhost:8080/Voids/Course/deleteall.do">
		<div class="container">
			<a  type="button"  href="ACourse"
				class="btn btn-info dropdown-toggle" >添加</a>

			<button onclick="deleteAll()" type="submit" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all"></th>
						<th>序号</th>
						<th style="width: 16%">标题</th>
						<th style="width: 60%">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
		<c:forEach begin="0" end="${list.size()-1}" var="i">
					<tr>
					
						<td><input type="checkbox" > </td>
						<td>${i }<input type="hidden" id="id" value="${list[i].id }"></td>
						<td>${list[i].course_title}</td>
						<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${list[i].course_desc}</td>
						<td><a href="Ucourse?id=${list[i].id }">✎</a></td>
						<td><a onclick="Delete(${list[i].id })"  >X</a></td>
					</tr>
		</c:forEach>
        
        </tbody>
      </table>
    
	</div>
	  </form>
		

<div style="float: left;width:100%;margin-top: 70px; ">



<div style="float:left;width:210px;height:80px;">
		
		<c:if test="${count%2==0}">
			<c:set value = "${count/2}" var="page"></c:set>
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			总共${count}条记录,共${page}页
		</c:if>
		<c:if test="${count%2!=0}">
			<c:set value = "${count/2 +1 }" var="page"></c:set>
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			总共${count}条记录,共${page}页
		</c:if>
		
		<c:if test="${pagee > 1}">
			<a href="courseAll?page=${pagee-1}">上一页</a>
		</c:if>
</div>
		<div style="float: left">
			<c:forEach var="i" begin="1" end="${page}">
				<a href="courseAll?page=${i}">第${i}页</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<div style="float: left; width: 50px">
			<c:if test="${pagee < page}">
				<a href="courseAll?page=${pagee+1}">下一页</a>
			</c:if>
		</div>

	</div>	


	<script type="text/javascript">
	function Delete(id){
		var d = id;
		  if (confirm("确定删除嘛?")) {
			 
			  $.ajax({
					url:"Dcourse",	
					type:"get",		
					data:{			
						name:d
					},
					success:function(data){
						 location.reload();
						alert("删除成功");
					}
				})
		  }
	}
	</script>

</body>
</html>