<%@ include file="../jsp/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
</head>

<body>
	<!-- navigator -->
	<jsp:include page="../jsp/include/navigator.jsp" flush="true" />
	
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Clean Blog</h1>
						<hr class="small">
						<span class="subheading">A Clean Blog Theme by Start
							Bootstrap</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-preview">
					<a href="<%=webContextPath%>/post">
						<h2 class="post-title">Man must explore, and this is
							exploration at its greatest</h2>
						<h3 class="post-subtitle">Problems look mighty small from 150
							miles up</h3>
					</a>
					<p class="post-meta">
						Posted by <a href="#">Start Bootstrap</a> on September 24, 2014
					</p>
				</div>
				<hr>
				
				<% List<PostModel> allPosts = (List<PostModel>)request.getAttribute(WebConstant.ALL_POSTS);
				if(allPosts==null)
				{
					
				}
				else
				{
					for (PostModel post : allPosts)
					{
						String createBy = post.getUserName()==null?"":post.getUserName()+"";
						String creationDate = post.getFormattedCeationDate()==null?"":post.getFormattedCeationDate().toString();
				%>
					<div class="post-preview">
						<a href="<%=webContextPath%>/post/getOnePost?id=<%=post.getId()%>">
							<h2 class="post-title"><%=post.getTitle() %></h2>
						
						
						<% if(post.getNoTagContent().length() > 50) { %>		
							<h3 class="post-meta"><%= post.getNoTagContent().substring(0, 50) %></h3>				
						<%} else {%>
							<h3 class="post-meta"><%= post.getNoTagContent() %></h3>							
						<%} %>
						</a>
						
						<p class="post-meta">
							Posted by <%=createBy%> on <%=creationDate %>
						</p>
					</div>
					<hr>					
				<%
					}
				}	
				%>
				
<!-- 				<div class="post-preview"> -->
<%-- 					<a href="<%=webContextPath%>/post"> --%>
<!-- 						<h2 class="post-title">I believe every human has a finite -->
<!-- 							number of heartbeats. I don't intend to waste any of mine.</h2> -->
<!-- 					</a> -->
<!-- 					<p class="post-meta"> -->
<!-- 						Posted by <a href="#">Start Bootstrap</a> on September 18, 2014 -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<hr> -->
<!-- 				<div class="post-preview"> -->
<%-- 					<a href="<%=webContextPath%>/post"> --%>
<!-- 						<h2 class="post-title">Science has not yet mastered prophecy -->
<!-- 						</h2> -->
<!-- 						<h3 class="post-subtitle">We predict too much for the next -->
<!-- 							year and yet far too little for the next ten.</h3> -->
<!-- 					</a> -->
<!-- 					<p class="post-meta"> -->
<!-- 						Posted by <a href="#">Start Bootstrap</a> on August 24, 2014 -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<hr> -->
<!-- 				<div class="post-preview"> -->
<%-- 					<a href="<%=webContextPath%>/post"> --%>
<!-- 						<h2 class="post-title">Failure is not an option</h2> -->
<!-- 						<h3 class="post-subtitle">Many say exploration is part of our -->
<!-- 							destiny, but itâs actually our duty to future generations.</h3> -->
<!-- 					</a> -->
<!-- 					<p class="post-meta"> -->
<!-- 						Posted by <a href="#">Start Bootstrap</a> on July 8, 2014 -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<hr> -->
				<!-- Pager -->
				<ul class="pager">
					<li class="next"><a href="#">Older Posts &rarr;</a></li>
				</ul>
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<jsp:include page="../jsp/include/footer.jsp" flush="true" />
	</footer>
</body>

</html>
