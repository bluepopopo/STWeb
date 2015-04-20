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
				<!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
				<!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
				<!-- NOTE: To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
				<form name="sentMessage" id="contactForm" novalidate >
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Name</label> <input type="text" class="form-control"
								placeholder="Name" id="username" required
								data-validation-required-message="Please enter user name.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> <input type="password"
								class="form-control" placeholder="Password" id="password"
								required
								data-validation-required-message="Please enter your email address.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div id="success"></div>
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember me
						</label>
					</div>
					<div class="row">
						<div class="form-group col-xs-12">
							<button class="btn btn-lg btn-primary btn-block" type="button" onclick="submitButton()">Sign
								in</button>
						</div>
						
						<div class="form-group col-xs-12">
							<font color="red"><label id="error"></label></font>
						</div>						
						
					</div>
				</form>
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
