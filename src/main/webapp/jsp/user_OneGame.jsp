<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="css/bootstrap.min.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css7/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<link rel="stylesheet" href="<c:url value="css/slick.css"/>">
<meta charset="UTF-8">
<title>Game eiei</title>
<style type="text/css">
body {
	margin-top: 0;
	margin-bottom: 2%;
}

.head h1 {
	text-align: center;
	margin-top: 50px;
	margin-bottom: 25px;
}

img {
	width: 70%;
	height: 500px;
	object-fit: cover;
	border-radius: 5px;
}

.img-con {
	margin: 0 8%;
	text-align: center;
}

.item .info-con {
	text-align: start;
	margin-top: 3%;
	margin-bottom: 3%;
	/* margin: 2% 10%; */
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}

.container .row .col {
	border: 1px solid #888686;
	background-color: #D9D9D9;
}

.h1, h1 {
	font-size: 3.3rem;
}

.dev {
	margin-left: 11%;
	margin-top: 20px;
}

form {
	margin-top: 20px;
	width: 80%;
	margin-right: auto;
	margin-left: auto;
}

.row {
	justify-content: flex-end;
}

.pp {
	margin-left: 8%;
	margin-top: 20px;
}

.filter {
	background: rgb(233, 76, 161);
	background: -moz-linear-gradient(90deg, rgba(233, 76, 161, 1) 0%,
		rgba(199, 74, 233, 1) 100%);
	background: -webkit-linear-gradient(90deg, rgba(233, 76, 161, 1) 0%,
		rgba(199, 74, 233, 1) 100%);
	background: linear-gradient(90deg, rgba(233, 76, 161, 1) 0%,
		rgba(199, 74, 233, 1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#e94ca1",
		endColorstr="#c74ae9", GradientType=1);
}

table {
	/* margin-top:3%;' */
	width: 60%;
	border-collapse: collapse;
	border-spacing: 0;
	box-shadow: 0 2px 15px rgba(64, 64, 64, .7);
	border-radius: 12px 12px 12px 12px;
	overflow: hidden;
	margin: auto;
}

td, th {
	padding: 15px 20px;
	text-align: center;
}

th {
	background-color: #BB0303;
	color: #fafafa;
	font-family: 'Open Sans', Sans-serif;
	font-weight: 200;
	text-transform: uppercase;
}

tr {
	width: 100%;
	background-color: #fafafa;
	font-family: 'Montserrat', sans-serif;
}

section {
	position: relative;
	height: 250px;
	width: 1075px;
	display: flex;
	align-items: center;
	margin-left: auto;
	margin-right: auto;
}

.swiper {
	width: 950px;
}

.card {
	position: relative;
	background: #fff;
	border-radius: 20px;
	margin: 20px 0;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
}

.card::before {
	content: "";
	position: absolute;
	height: 40%;
	width: 100%;
	border-radius: 20px 20px 0 0;
}

.card .card-content {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 30px;
	position: relative;
	z-index: 100;
}

.card .name-profession, .card .comment {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 10px;
	color:;
}

.name-profession .name {
	font-size: 20px;
	font-weight: 600;
}

.comment .comment1 {
	font-size: 16px;
	width: 60%;
}

.swiper-pagination {
	position: absolute;
}

.swiper-pagination-bullet {
	height: 7px;
	width: 26px;
	border-radius: 25px;
	background: #BB0303;
}

.swiper-button-next, .swiper-button-prev {
	opacity: 0.7;
	color: #BB0303;
	transition: all 0.3s ease;
}

.swiper-button-next:hover, .swiper-button-prev:hover {
	opacity: 1;
	color: #BB0303;
}

#game_content::first-letter {
	font-size: 30px;
}

@media only screen and (max-width: 1180px) {
	.carousel {
		width: 90%;
	}
}
</style>
</head>
<body>
	<jsp:include page="${set_nav}" />
	<div class="head">
		<h1>${one_games.game_name}</h1>
	</div>

	<div class="container1">
		<div class="item">
			<div class="img-con">
				<img alt="image" src="${one_games.image}">
				<!-- ใส่ ${รูปภาพแทน } -->
			</div>
			<br>
			<div class="col-auto"
				style="text-align: end; width: 60%; margin-left: auto; margin-right: auto;">
				${all_like} ถูกใจ
				<%
				Integer id1 = (Integer) session.getAttribute("id");
				if (id1 == null) {
				%>
				<%
				} else {
				%>
				<button type="button" class="btn btn-outline-danger"
					style="border: 0px">
					<a
						href="/user_OneGame?game_id=${one_games.game_id}&icon=${Like_yes}&action=like"><img
						alt="" src="${Like_yes}" style="width: 25px; height: 25px">
					</a>
				</button>
				<%
				}
				%>

			</div>

			<div class="info-con" style="font-size: 18px" id="game_content">
				<p>&emsp;&emsp;${one_games.game_content}</p>
				<br>
				<p style="font-size: 13px; color: #">ผู้พัฒนา :
					${one_games.developBy}</p>
				<p style="font-size: 13px; color: #">ผู้จำหน่าย :
					${one_games.distributorsBy}</p>
			</div>






		</div>
	</div>



	<table>



		<tr>

			<th>ช่องทางจำหน่าย</th>

			<th>ราคา</th>



		</tr>

		<c:forEach items="${platform}" var="plateform_list">
			<tr>
				<td>${plateform_list[1]}</td>
				<td>${plateform_list[2]}บาท</td>

			</tr>

		</c:forEach>
	</table>
	<br>






	<table>



		<tr>


			<th>แนวเกม</th>

			<th>ระบบปฏิบัติการ</th>

			<th>การเข้าชม</th>

		</tr>







		<td rowspan="2"><c:forEach items="${list_category}"
				var="list_category">
				<p>${list_category[1]}</p>
			</c:forEach></td>

		<td rowspan="2"><c:forEach items="${list_os}" var="list_os">
				<!-- <img alt="" src="https://cdn-icons-png.flaticon.com/512/2/2235.png">
				<img alt="" src="https://cdn-icons-png.flaticon.com/512/732/732076.png"> -->
				<p>${list_os[1]}</p>
			</c:forEach></td>

		<td rowspan="2">จำนวนการเข้าชม ${one_games.game_view} ครั้ง</td>





	</table>





	<hr>
	<div class="container text-center">
		<div class="row justify-content-between">
			<div class="col-2">${all_comment.size()}ความคิดเห็น</div>


		</div>
	</div>

	<section>

		<div class="swiper mySwiper container">
			<div class="swiper-wrapper content">

				<c:forEach items="${all_comment}" var="comment_list">
					<div class="swiper-slide card">
						<div class="card-content">

							<div class="name-profession">
								<span class="name"> ${comment_list[1]}</span>
							</div>

							<div class="comment">
								<span>${comment_list[2]}</span>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>

		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
		<div class="swiper-pagination"></div>
	</section>




	<%
	Integer id2 = (Integer) session.getAttribute("id");
	if (id2 == null) {
	%>

	<%
	} else {
	%>

	<form class="row g-3" action="/user_OneGame">
		<div class="col-6">
			<input type="text" class="form-control" id="inputPassword2"placeholder="เขียนความคิดเห็น" name="comment_content" required="required">
			<input type="text"  name="game_id" value="${one_games.game_id}" style="display: none;">
			<input type="number"  name="user_id" value="<%=(Integer)session.getAttribute("id") %>" style="display: none;">
			<input type="tel"  name="icon" value="" style="display: none;">
			<input type="tel"  name="action" value="save_comment" style="display: none;">
			<!-- <input type="text" name="action_comment" value= "true" style="display: none;"> -->
		</div>
					

		<div class="col-auto">
		
			<input type="submit" class="btn btn-outline-danger" value="ส่ง">
			
		</div>

	</form>
	<%
	}
	%>


	<jsp:include page="footer.jsp" />
	<script src="<c:url value="js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="js/jquery.js"/>"></script>
	<script src="<c:url value="js/slick.min.js"/>"></script>
	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->

	<script>
		var swiper = new Swiper(".mySwiper", {
			slidesPerView : 3,
			spaceBetween : 30,
			slidesPerGroup : 3,
			loop : true,
			loopFillGroupWithBlank : true,
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>