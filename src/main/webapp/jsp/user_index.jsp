<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>
	<jsp:include page="${set_nav}" />
	<%-- ${hello} --%>
	<br>
	<div class="container">
		<div class="img-home">
			<img src="img/varorant1.png" class="img-fluid" alt="..." width="100%">
		</div>


		<div class="sug">
			<h3>SUGGESTION</h3>
			<br> <br>
			<div class="row">

				<c:forEach items="${find3Game}" var="find3Game_list">
					<div class="col-sm">
						<div class = "view">${find3Game_list[4]} views</div>

						<div class="card_mv">
							<a href="/user_OneGame?game_id=${find3Game_list[0]}&icon&action">
								<div>
									<img class="img_mv" src="${find3Game_list[3]}" alt="">
								</div>
								<div class="title_mv">${find3Game_list[1]}</div>
						</div>
						</a>
					</div>
				</c:forEach>

			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />
	<script src="<c:url value="js/bootstrap.min.js"/>"></script>
</body>
</html>