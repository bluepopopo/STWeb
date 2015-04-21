<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 // web context path
 String webContextPath = request.getContextPath();
%>

<div class="container">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
			<ul class="list-inline text-center">
				<li><a href="#"> <span class="fa-stack fa-lg"> <i
							class="fa fa-circle fa-stack-2x"></i> <i
							class="fa fa-weibo fa-stack-1x fa-inverse"></i>
					</span>
				</a></li>
				<li><a href="#"> <span class="fa-stack fa-lg"> <i
							class="fa fa-circle fa-stack-2x"></i> <i
							class="fa fa-facebook fa-stack-1x fa-inverse"></i>
					</span>
				</a></li>
				<li><a href="#"> <span class="fa-stack fa-lg"> <i
							class="fa fa-circle fa-stack-2x"></i> <i
							class="fa fa-github fa-stack-1x fa-inverse"></i>
					</span>
				</a></li>

				<li><a href="#"> <span class="fa-stack fa-lg"> <i
							class="fa fa-square fa-stack-2x"></i> <i
							class="fa fa-linkedin fa-stack-1x fa-inverse"></i>
					</span>
				</a></li>
								
			</ul>
			<p class="copyright text-muted">Copyright &copy;2015 XiaoCoder.com</p>
		</div>
	</div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=webContextPath%>/js/clean-blog.min.js"></script>