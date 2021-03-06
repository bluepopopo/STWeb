<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=webContextPath%>/">STWeb Blogger</a>
			<%
				if (isLoggedIn)
				{
			%>
			</br>
			<a class="navbar-brand" href="#">[<%=user.getUserName()%>] already logged in</a>
			<%
				}
			%>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=webContextPath%>/">Home</a></li>
				<li><a href="<%=webContextPath%>/about">About</a></li>
				<li><a href="<%=webContextPath%>/post/viewPost">Sample Post</a></li>
				<li><a href="<%=webContextPath%>/contact">Contact</a></li>				
			<%
				if (isLoggedIn)
				{
			%>
			<li><a href="<%=webContextPath%>/post/addPost">Add New Post</a></li>
			<%
				}
			%>				
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>