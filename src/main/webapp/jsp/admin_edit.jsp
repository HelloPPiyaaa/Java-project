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
.box-category {
	margin-left: 20px;
	width: 60%
}
</style>
</head>
<body>
	<jsp:include page="admin_nav.jsp" />

	<div class="container" id="box1">
		<h3>แก้ไขเกม</h3>
		<div class="row">
			<div class="col-sm">

				<form action="/form_admin_edit">
				
					<div>

					
						<div>
						<label for="exampleFormControlInput1">หมายเลขเกม </label> <br>
							<input   disabled="disabled" type = "text" value="${one_games_edit.game_id}">
							<input style="display: none;"  name="game_id"  type = "text" value="${one_games_edit.game_id}">
						</div>
						<br>

						<div>
							<div class="form-group">
								<label for="exampleFormControlInput1">ชื่อเกม*</label> <input
									name="game_name" required type="text" class="form-control"
									id="exampleFormControlInput1"
									value="${one_games_edit.game_name}" />
							</div>
						</div>
						<br> 

						<div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">เนื้อหา*</label>
								<textarea name="game_content" class="form-control"
									id="exampleFormControlTextarea1" rows="3">${one_games_edit.game_content}</textarea>
							</div>

							<div>
								<div class="form-group">
									<label for="exampleFormControlInput2">ชื่อบริษัทผู้พัฒนา*</label>
									<input required type="text" class="form-control"
										name="deverlopBy" id="exampleFormControlInput2"
										value="${one_games_edit.developBy}" />
								</div>
							</div>

							<div>
								<div class="form-group">
									<label for="exampleFormControlInput3">ชื่อบริษัทผู้จัดจำหน่าย*</label>
									<input required type="text" class="form-control"
										name="distributorsBy" id="exampleFormControlInput3"
										value="${one_games_edit.distributorsBy}" />
								</div>
							</div>


							<div class="form-group">
								<label for="exampleFormControlInput1">url รูปภาพ</label> <input
									name="link_image" type="text" class="form-control-file"
									id="link_image" value="${one_games_edit.image}" />
									
									<br>
									 <img id="img" src="${one_games_edit.image}" style="width: 100px">
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


	<script type="text/javascript">
	const input = document.getElementById("link_image");
	const output = document.getElementById("img");


	input.addEventListener("input", () => {
		output.src = input.value;
	});
	</script>


</body>
</html>