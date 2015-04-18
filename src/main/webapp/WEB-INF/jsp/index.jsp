<%@ include file="../jsp/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">

				<!-- navigator -->
				<div>
					<div><br></div>
					<jsp:include page="../jsp/include/navigator.jsp" flush="true"/>
				</div>

				<div class="carousel slide" id="carousel-31486">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0" data-target="#carousel-31486">
						</li>
						<li data-slide-to="1" data-target="#carousel-31486"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="http://7xidoc.com1.z0.glb.clouddn.com/logo.png"
								width="100%" />
							<div class="carousel-caption">
								<h1>SIBOVALVE</h1>
								<h2>未来无限可能<h2>
							</div>
						</div>
						<div class="item">
							<img alt=""
								src="http://7xidoc.com1.z0.glb.clouddn.com/desc14.png"
								width="100%" />
							<div class="carousel-caption">
								<h1>SIBOVALVE</h1>
								<h2>专业  · 专注  · 极致<h2>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-31486"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-31486"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>

				<div><br></div>
				<div class="jumbotron">
					<h1>非常抱歉，网站正在维护！</h1>
				</div>
									
				<!-- footer -->
				<div>
					<div><br></div>
					<jsp:include page="../jsp/include/footer.jsp" flush="true"/>
				</div>
				
			</div>
		</div>
	</div>


</body>

</html>