<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/index.css" />
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
		.box-category{
			margin-left: 20px;
			width: 60%
			
			
		}
</style>


</head>
<body>

<!-- <form action="/form_admin_add">
	test<input type="text" name="test">
	<input type="checkbox" id="category1" name="category"value="เอาชีวิตรอด"> 
	<input type="checkbox" id="category2" name="category"value="dddd">
	<input type="file"name="photo" />
	
	<textarea rows="10" cols="10" name="textarea"></textarea>
	 
	<input type="submit">
</form> -->

	<jsp:include page="admin_nav.jsp" />
	<div class="container" id="box1">
		<h3>เพิ่มเกม</h3>
		<div class="row">
			<div class="col-sm">

				<form action="/form_admin_add" method="post">
				
			<div>
					<div>
						<div class="form-group">
							<label for="exampleFormControlInput1">ชื่อเกม*</label>
							 <input name = "game_name"
								required type="text" class="form-control"
								id="exampleFormControlInput1" />
						</div>
					</div>
<br>
				หมวดหมู่เกม*
				<br>
				<br>
					<div class="box-category">
						<div class="form-group">
						<input type="checkbox" id="category1" name="category"value="1">  
						เอาชีวิตรอด<br>
						<input type="checkbox" id="category2"name="category" value="2"> 
						ผจญภัย<br>
						<input type="checkbox" id="category3" name="category" value="3"> 
						อินดี้<br>
						<input type="checkbox" id="category4" name="category"value="4"> 
						แอ็คชัน<br>
						<input type="checkbox" id="category5" name="category" value="5"> 
						จำลองสถานการณ์<br>
						<br>
						</div>
					</div>
					<div>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">เนื้อหา*</label>
							<textarea name = "game_content" class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
					</div>
					<div>
						<div class="form-group">
							<label for="exampleFormControlInput2">ชื่อบริษัทผู้พัฒนา*</label>
							<input required type="text" class="form-control" name="deverlopBy"
								id="exampleFormControlInput2" />
						</div>
					</div>

					<div>
						<div class="form-group">
							<label for="exampleFormControlInput3">ชื่อบริษัทผู้จัดจำหน่าย*</label>
							<input required type="text" class="form-control" name="distributorsBy"
								id="exampleFormControlInput3" />
						</div>
					</div>

แหล่งจำหน่าย
				<div class="box-category">
				
						<div class="form-group">
							
						<input class="checkbox" type="checkbox" id=plat1 name="plat"value="0 STEAM"> 
						<label for="plat1">STEAM</label>
						<input type="number" id="price1" name="price" style="display:none;" min="0" value=99999999>  <br>
						
						<input class="checkbox" type="checkbox" id="plat2"name="plat" value="1 ORIGIN"> 
						<label for="plat2">ORIGIN</label>
						<input type="number" id="price2" name="price" style="display:none;" min="0" value=99999999> <br> 
						
						<input class="checkbox" type="checkbox" id="plat3" name="plat" value="2 GOG.COM"> 
						<label for="plat3">GOG.COM</label>
						<input type="number" id="price3" name="price" style="display:none;" min="0" value=99999999> <br> 
						
						<input class="checkbox" type="checkbox" id="plat4" name="plat"value="3 Ubisoft"> 
						<label for="plat4">Ubisoft</label>
						<input type="number" id="price4" name="price" style="display:none;" min="0" value=99999999> <br> 
						
						<input class="checkbox" type="checkbox" id="plat5" name="plat" value="4 EPIC"> 
						<label for="plat1">EPIC</label>
						<input type="number" id="price5" name="price" style="display:none;"  min="0" value=99999999> <br> 
						<br>
						</div>
					</div>
					
					ระบบปฏิบัติการ  <br>
					<input id="os1" type="checkbox"  name="os"value="windows">
					<label for="os1">windows</label>
					
					 
					<input id="os2" type="checkbox" name="os"value="macOS"> 
					<label for="os2">macOS</label>
					
						<div>
						<div class="form-group">
							<label for="exampleFormControlFile1">url รูปภาพ*</label>
							 <input
							    name = "link_image"
								type="texe" class="form-control-file"
								id="link_image" />
								
								<img id="img" src="" style="width: 100px">
						</div>
					</div>
					
						<div class="button1">
						<input type="submit" value="บันทึก">
					</div>
					
					</div>
				</form>
			</div>
		</div>

	</div>
	

	
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	//var string_array_price = document.getElementById("plat1");
	
	var plat1 = document.getElementById("plat1");
	var price1 = document.getElementById("price1");
	plat1.addEventListener('change', function() {
		if (this.checked) {
			price1.style.display = 'block';
			price1.value = 0;
		} else {
			price1.value = 9;
			price1.style.display = 'none';
			
		}
	}); 

var plat2 = document.getElementById("plat2");
var price2 = document.getElementById("price2");
plat2.addEventListener('change', function() {
	if (this.checked) {
		price2.style.display = 'block';
		price2.value = 0;
	} else {
		price2.value = 9;
		price2.style.display = 'none';
		
	}
}); 

var plat3 = document.getElementById("plat3");
var price3 = document.getElementById("price3");
plat3.addEventListener('change', function() {
	if (this.checked) {
		price3.style.display = 'block';
		price3.value = 0;
	} else {
		price3.value = 9;
		price3.style.display = 'none';
		
	}
}); 

var plat4 = document.getElementById("plat4");
var price4 = document.getElementById("price4");
plat4.addEventListener('change', function() {
	if (this.checked) {
		price4.style.display = 'block';
		price4.value = 0;
	} else {
		price4.value = 9;
		price4.style.display = 'none';
		
	}
}); 

var plat5 = document.getElementById("plat5");
var price5 = document.getElementById("price5");
plat5.addEventListener('change', function() {
	if (this.checked) {
		price5.style.display = 'block';
		price5.value = 0;
	} else {
		price5.value = 9;
		price5.style.display = 'none';
		
	}
}); 


const input = document.getElementById("link_image");
const output = document.getElementById("img");


input.addEventListener("input", () => {
	output.src = input.value;
});


</script>

</body>
</html>