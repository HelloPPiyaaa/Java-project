<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="${set_nav}" />

	<div class="container">
	

		<img src="img/allmv.jpg" class="img-fluid" alt="..." width="100%">

		<div class="row">
		
		<c:forEach items="${game_all}" var="game_list">
	
			<div class="col-sm">
				<div class="card_mv">
					<a href="/user_OneGame?game_id=${game_list.game_id}&icon&action">
						<div>
							<img class="img_mv" src="${game_list.image }" alt="">
						</div>
						<div class="title_mv">${game_list.game_name }</div>
				</div>
				</a>
			</div>
		</c:forEach>

		
		</div>
	</div>
	<jsp:include page="footer.jsp" />
<script src="js/bootstrap.min.js"></script>
</body>
</html>