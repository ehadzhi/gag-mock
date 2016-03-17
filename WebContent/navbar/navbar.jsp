<%@page import="info.Info"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<img class="navbar-brand" src="/gagmock/images/sheep-icon.png"
				alt="Mountain View"> <a class="navbar-brand" href="/gagmock">GagMock</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<%
					String currentPage = (String) request.getSession().getAttribute(Info.CURRENT_PAGE_LABEL);
				%>
				<li <%if (currentPage.equals("hot")) {%> class="active" <%}%>><a
					href="/gagmock/navigate?active_page=hot">Hot </a></li>
				<li <%if (currentPage.equals("fresh")) {%> class="active" <%}%>><a
					href="/gagmock/navigate?active_page=fresh">Fresh</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">More <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Funny</a></li>
						<li><a href="#">Cry</a></li>
						<li><a href="#">Cosplay</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">NSFW</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Videos</a></li>
					</ul></li>
			</ul>

			<%
				Object isLoggedIn = request.getSession().getAttribute(Info.LOGGED_IN_LABEL);
				if (isLoggedIn != null && isLoggedIn.equals(Info.TRUE_LABEL)) {
			%>
			<jsp:include page="logged-in.jsp" />
			<%
				} else {
			%>
			<jsp:include page="register-login.jsp" />
			<%
				}
			%>
			<form class="navbar-form navbar-right" action="/gagmock/queries/search.jsp"
				role="search" method="get">
				<div class="form-group">
					<input type="text" name="search-query" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</button>
			</form>
		</div>
	</div>
	<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>