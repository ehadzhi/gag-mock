<%@page import="info.ErrorInfo"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="info.Info"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionDispatcher"%>
<!doctype html>
<html>
<head>
<title>GagMock - Jokes die here.</title>
<link rel="shortcut icon" type="image/x-icon"
	href="./images/sheep-icon.png" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<style>
.modal-backdrop {
	bottom: 0;
	z-index: 1020;
}
</style>
</head>
<body class="background - white" style="padding-top: 50px">
	<header>
		<jsp:include page="navbar.jsp" />
	</header>

	<div class="container-fluid" style="background: #222">
		<h1 align="middle">
			<img src="images/avatar/avatar_default.jpg">
			<%
				Connection con = ConnectionDispatcher.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt
						.executeQuery("select * from account where account_id = " + request.getParameter("user_id"));
				if (!res.next()) {
					response.sendRedirect(ErrorInfo.BAD_PARAMETERS);
				}
			%>
			<p style="color: white">
				<%
					out.print(res.getString(Info.USER_LABEL));
				%>
			</p>
		</h1>
	</div>

	<div class="container">
		<ul class="nav nav-pills">
			<li role="presentation"><a href="#">Overview</a></li>
			<li role="presentation" class="active"><a href="#">Posts</a></li>
			<li role="presentation"><a href="#">Upvotes</a></li>
			<li role="presentation"><a href="#">Comments</a></li>
		</ul>
	</div>

	<jsp:include
		page="post-user-list.jsp" />
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>