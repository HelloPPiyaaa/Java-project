<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/bootstrap.min.css"/>


<meta charset="UTF-8">
<title>Game eiei</title>
<style type="text/css">


body{
	min-width: 1300px;
}
.re-e{
	background-color: #F9F9F9;
	padding: 40px 100px;
	margin: 150px 450px;
	border: 1px solid #B7B1B1;
	border-radius: 30px;
}
.re-e h1, .button-e {
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

.submit:hover {
	background-color: # A9A9A;
}


</style>
</head>
<body>
<jsp:include page="user_nav_yes.jsp" />
<form action="/form_register" class="re-e">

            <h1>ลงทะเบียน</h1>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">ชื่อผู้ใช้</label>
                <input name="username" value="${message[1]}" type="text" class="form-control" id="exampleFormControlInput1" placeholder="" required>
            </div>
            <p style="color: ${message[2]} ; text-align:end ;  font-size:10px; ">${message[0]}</p>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">รหัสผ่าน</label>
                <input name="password" type="tel" class="form-control" id="exampleFormControlInput1" placeholder="" required>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">ยืนยันรหัสผ่าน</label>
                <input name="password2" type="tel" class="form-control" id="exampleFormControlInput1" placeholder="" required>
            </div>
             <input name="status" type="text" value = "user" style="display: none;">
            <p style=" color:${message[4]} ; text-align:end;  font-size:10px; " >${message[3]}</p>
            
            <input style="background-color: #D3D3D3" type="submit" value="สมัคร" class="form-control submit" id="exampleFormControlInput1">
           
           <!--  
            <div class="button-e">
                <a href="#" class="btn   fw-bold" style="border-radius: 10px!important; background-color: #BB0303; color: white;">ลงทะเบียน</a>
            </div>
            -->
    </form>
    <jsp:include page="footer.jsp" />
<script src="js/bootstrap.min.js"></script>
</body>
</html>