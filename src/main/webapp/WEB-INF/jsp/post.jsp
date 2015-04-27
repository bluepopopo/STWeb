<%@ include file="../jsp/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript">
		/**
		* Go to edit post.
		*/
		function editButton(id)
		{
			var url = "<%=webContextPath%>/post/editPost?id="+id;
			location.href=url;	
		}
		
		function deleteButton(id)
		{
			var data = {
					"postModel.id" : $('#id').val()
				};
			$.post('<%=webContextPath%>/post/delete', data, function(data) {
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
	<jsp:include page="../jsp/include/navigator.jsp" flush="true" />

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('<%=webContextPath%>/img/post-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-heading">
                        <h1>Man must explore, and this is exploration at its greatest</h1>
                        <h2 class="subheading">Problems look mighty small from 150 miles up</h2>
                        <span class="meta">Posted by <a href="#">Start Bootstrap</a> on August 24, 2014</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post Content -->
    <article>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                
                
				<% PostModel post = (PostModel)request.getAttribute(WebConstant.ONE_POST);
				if(post==null)
				{
					
				}
				else
				{					
				%>
					<div class="post-preview">
						<h2 class="post-title"><%=post.getTitle() %></h2>	
						<p class="post-meta"><%= post.getContent() %></p>
						<p class="post-meta">
							Posted by <a href="#"><%=post.getCreateBy()%></a> on <%=post.getCreateBy() %>
						</p>
					</div>
					<input type="hidden" id="id" value="<%=post.getId() %>" />
					
						<%
				if (isLoggedIn)
				{
					%>
					<div>
						<table>
							<tr>
								<td>						
									<button class="btn btn-default btn-sm" type="button" onclick="editButton('<%=post.getId() %>')">Edit</button>
								</td>
								<td>
									&nbsp;
								</td>
								<td>
									<button class="btn btn-default btn-sm" type="button" onclick="deleteButton('<%=post.getId() %>')">Delete</button>
								</td>
							</tr>	
						</table>
					</div>
					<%
						}
					%>																								
					
					<hr>					
				<%
				}	
				%>
                </div>
            </div>
        </div>
    </article>

    <hr>

	<!-- Footer -->
	<footer>
		<jsp:include page="../jsp/include/footer.jsp" flush="true" />
	</footer>

</body>

</html>
