<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="css/bootstrap.min.css"/>">
<meta charset="UTF-8">
<title>Game eiei</title>
<style type="text/css">

body{
	min-width: 1300px;
}

.pro-e{
	background-color: #F9F9F9;
	padding: 40px 100px;
	margin: 150px 450px;
	border: 1px solid #B7B1B1;
	border-radius: 30px;
}
.pro-e h1, .button-edit {
	text-align: center;
}
footer{
    clear: both;
}
.pro-e label{
    font-weight: bold;
}
.link-regis {
	text-align: center;
	color: black;
	margin-top: 10px;
}



</style>
</head>
<body>
<jsp:include page="user_nav_no.jsp" />
<form action="/form_login" class="pro-e" method="post">
            <h1>เข้าสู่ระบบ</h1>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">ชื่อผู้ใช้</label>
                <input name="username"  type="text" class="form-control" id="exampleFormControlInput1" placeholder="username" required>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">รหัสผ่าน</label>
                <input name = "password" type="text"  class="form-control" id="exampleFormControlInput1" placeholder="password"required>
            </div>
            <p style="color: red">${message}</p>
            
             <input type="submit" class="form-control" id="exampleFormControlInput1"  value = "login">
            <!-- 
            <div class="button-edit">
                <a href="#" class="btn   fw-bold" style="border-radius: 10px!important; background-color: #BB0303; color: white;">เข้าสู่ระบบ</a>
            </div>
            -->
            <div class="link-regis">
            	<a href="/register" class="lregis" style="color: black;"><u>ลงทะเบียน</u></a>
            </div>
    </form>
    <jsp:include page="footer.jsp" />
<script src="<c:url value="js/bootstrap.min.js"/>"></script>
</body>
</html>