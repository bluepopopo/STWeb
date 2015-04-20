<%@ include file="../../jsp/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
</head>

<body>

	<!-- navigator -->
	<jsp:include page="../../jsp/include/navigator.jsp" flush="true" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('<%=webContextPath%>/img/contact-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="page-heading">
						<h1>Please login</h1>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<jsp:include page="../../jsp/include/footer.jsp" flush="true" />
	</footer>

	<script type="text/javascript">
		function submitButton()
		{
			$("#error").html("");
			
			var data = {
					"userModel.user_name" : $("#username").val(),
					"userModel.password" : $("#password").val()
				};
			$.post('<%=webContextPath%>/user/login', data, function(data) {
				if (data.error) {
					$("#error").html(data.error);				
				} else {
					document.location = "<%=webContextPath%>/";
				}
			});
		}
	</script>
</body>

</html>
