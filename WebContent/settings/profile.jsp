<%@page import="info.ErrorInfo"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="info.Info"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionDispatcher"%>


<jsp:include page="/main/main-upper.jsp" />
	<div class="container-fluid" style="background: #222">
		<h1 align="middle">
			<img src="/gagmock/images/avatar/avatar_default.jpg">
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
		page="/queries/post-user-list.jsp" />
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>