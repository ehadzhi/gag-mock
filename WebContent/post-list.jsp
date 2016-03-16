
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="info.Info"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionDispatcher"%>
<%
	Connection con = ConnectionDispatcher.getConnection();
	Statement stmt = con.createStatement();
	ResultSet res;
	if (session.getAttribute(Info.CURRENT_PAGE_LABEL).equals("hot")) {
		res = stmt.executeQuery("select * from post order by points desc;");
	} else {
		res = stmt.executeQuery("select * from post order by create_time desc;");
	}
	while (res.next()) {
%>

<div class="container">
	<div class="col-lg-7 col-md-7 col-sm-12">
		<h1>
			<a href="/gagmock/post?post_id=<%out.print(res.getInt("post_id"));%>">
				<%
					out.print(res.getString("post_header"));
				%>
			
		</h1>
		<img src="post/<%out.print(res.getString("picture_path"));%>"
			class="img-responsive" alt="img">
		<p></p>
		<button type="button" class="btn btn-link btn-xs">
			Points:
			<%
			out.print(res.getString("points"));
		%>
		</button>
		<button type="button" class="btn btn-link btn-xs">Comments</button>
		<p></p>
		<div class="btn-group" role="group" aria-label="...">
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
			</button>
		</div>
		<button type="button" class="btn btn pull-right btn-primary ">Facebook</button>
		<button type="button" class="btn btn pull-right btn-info">Twitter</button>
		<hr></hr>
	</div>
</div>

<%
	}
%>