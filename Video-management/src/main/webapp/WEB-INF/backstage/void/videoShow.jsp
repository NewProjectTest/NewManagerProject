<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/confirm.js"></script>
<script src="js/jquery.js"></script>
<script src="js/message_cn.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />

</head>
<style type="text/css">
th {
	text-align: center;
}
</style>
<body>
	<div class="jumbotron" >
		<div class="container">
			<label>视频管理</label>
			<div style="float: right;">
			<form action="like" >
				<input type="text" name="text"> 
				
			    <label >主讲人</label> 
			    	<select name="sid" >
								<option value="" selected="selected">请选择主讲人</option>
							<c:forEach items="${slist }" var="list">
								<option  value="${list.id}">${list.speaker_name }</option>
							</c:forEach>
						</select>
					
			  
			
			    <label >所属课程</label>
			    	<select name="cid" >
						<option value="" selected="selected">请选择课程</option>
						<c:forEach items="${clist }" var="list">
				    		<option value="${list.id}" >${list.course_title}</option>
				  		</c:forEach>
				 	 </select>		
				<input type="submit" value="查询" > 
			</form>
			</div>
		</div>
	</div>
	
	<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
	<tr class="active">
		<td><input type="checkbox" onchange="a()" id="all"></td>
		<td>ID</td>
		<td>名称</td>
		<td>详情</td>
		<td>时间</td>
		<td>讲师名字</td>
		
		<td>视频url</td>
		<td>封面url</td>
		<td>播放次数</td>
		<td>操作</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
	<tr>
		<td><input type="checkbox" name="c" value="${list.video_id}"></td>
		<td>${list.video_id }</td>
		<td>${list.title }</td>
		<td>${list.detail }</td>
		<td>${list.time }</td>
		<td>${list.speaker.speaker_name }</td>
		
		<td>${list.video_url}</td>
		<td>${list.image_url }</td>
		<td>${list.play_num }</td>
		<td>
			<a class="btn btn-success" href="videoA?id=${list.video_id }">（编辑）</a>
			<a  class="btn btn-danger" href="Dvideo?id=${list.video_id }">（删除）</a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
	<button onclick="deleteAll()" class="btn btn-info dropdown-toggle">
		      批量删除
		</button>
<div style="float: left;width:100%;margin-top: 70px; ">



<div style="float:left;width:210px;height:80px;">
		
		<c:if test="${count%3==0}">
			<c:set value = "${count/3}" var="page"></c:set>
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			总共${count}条记录,共${page}页
		</c:if>
		<c:if test="${count%3!=0}">
			<c:set value = "${count/3 +1 }" var="page"></c:set>
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			总共${count}条记录,共${page}页
		</c:if>
		
		<c:if test="${pagee > 1}">
			<a href="voidShow?page=${pagee-1}">上一页</a>
		</c:if>
</div>
		<div style="float: left">
			<c:forEach var="i" begin="1" end="${page}">
				<a href="voidShow?page=${i}">第${i}页</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<div style="float: left; width: 50px">
			<c:if test="${pagee < page}">
				<a href="voidShow?page=${pagee+1}">下一页</a>
			</c:if>
		</div>

<a class="btn btn-success" href="videoA" >（添加）Add</a>
</div>	
	
<script type="text/javascript">
function a() {
	var stuts=document.getElementById("all").checked;
    
    var c=document.getElementsByName("c");
     for(var i=0;i<c.length;i++){
          c[i].checked=stuts;
      }
    
    };
    function deleteAll(){
    	
        var checkedNum  = $("input[name='c']:checked").length;
			var userIds = new Array();
          $("input[name='c']:checked").each(function(){
              userIds.push($(this).val());
          });
          
          if(confirm("确定删除所选项？")){
        	 
              $.post("dAll",{userIds:userIds},
                 function(data){
            	 
					if(data =='ok'){
						Confirm.show('温馨提示：', '删除成功');
						document.location.reload();
					}else{
						Confirm.show('温馨提示：', '操作失败');
					}
              	 });
         	}

    }
</script>	
	
	
	
</body>
</html>