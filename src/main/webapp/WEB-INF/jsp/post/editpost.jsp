<%@ include file="../../jsp/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<link rel="stylesheet"
	href="<%=webContextPath%>/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=webContextPath%>/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="<%=webContextPath%>/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="<%=webContextPath%>/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=webContextPath%>/js/kindeditor/plugins/code/prettify.js"></script>

<script>
	KindEditor.ready(function(K) {
		window.editor = K.create('#editor_id');
	});

	function submitButton() {		
		editor.sync();
		html = $('#editor_id').val(); // jQuery

		var data = {
				"postModel.id" : $('#id').val(),
				"postModel.title" : $('#title').val(),
				"postModel.content" : html
			};
		$.post('<%=webContextPath%>/post/update', data, function(data) {
			if (data.error) {
				$("#error").html(data.error);				
			} else {
				document.location = "<%=webContextPath%>/";
			}
		}); 
		
	}
</script>
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
						<h1>Add a new post</h1>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	
	<% PostModel post = (PostModel)request.getAttribute(WebConstant.ONE_POST);
	if(post==null)
	{
		
	}
	else
	{					
	%>

	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<form name="sentMessage" id="contactForm" novalidate>

					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Title</label> <input type="text" class="form-control"
								placeholder="Title" id="title" required
								value="<%=post.getTitle() %>">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<textarea id="editor_id" name="content"
								style="width: 750px; height: 300px;"><%=post.getContent() %></textarea>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-xs-12">
							<button class="btn btn-primary btn-block" type="button"
								onclick="submitButton()">Update</button>
						</div>						
					</div>
					
					<input type="hidden" id="id" value="<%=post.getId() %>"/>
				</form>
			</div>
		</div>
	</div>		
							
	<%
	}	
	%>

	<hr>

	<!-- Footer -->
	<footer>
		<jsp:include page="../../jsp/include/footer.jsp" flush="true" />
	</footer>
</body>

</html>
