<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/index.css" />

<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#list_game {
	width: 47%;
	margin-left: auto;
	margin-right: auto;
}

.btn_action {
	position: absolute;
}

.hover-action:hover {
	width: 50px;
}

.card_mv {
	width: 300px
}
</style>
</head>
<body>

	<jsp:include page="admin_nav.jsp" />
	<%-- ${find_latest_game_id} --%>

	<%-- ${findAll_Games_Admin[0][1]} --%>

	<br>
	<div class="row list_game" id="list_game">
		<c:forEach items="${findAll_Games_Admin}" var="game_list">

			<br>
			<div class="col-sm">

				<div class="card_mv">

					<div class="btn_action">
						<a class="btn-delete" href="/admin_delete?game_id=${game_list[0]}">
						<div>
								<img class="hover-action" width="40px" alt=""
									src="https://cdn-icons-png.flaticon.com/512/8848/8848798.png">
							</div>
						</a>

					</div>


					<div>
						<a href="/admin_edit?game_id=${game_list[0]}">
							<div>
								<img class="img_mv" src="${game_list[3]}" alt="">
							</div>
							<div class="title_mv">${game_list[1]}</div>
					</div>
					</a>

				</div>



			</div>
		</c:forEach>
	</div>

	<jsp:include page="footer.jsp" />
	<script src="js/bootstrap.min.js"></script>
</body>
</html>