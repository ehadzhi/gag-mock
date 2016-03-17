<%@page import="info.Info"%>

<jsp:include page="/main/main-upper.jsp" />
<div class="container">
	<div class="col-lg-12">
		<h1 class="text-center">
			<%
				out.print(request.getParameter(Info.ERROR_LABEL));
			%>
		</h1>
		<h2 class="text-center">You're going off rails.</h2>
		<img src="images/error.png" class="img-responsive center-block"
			alt="error img">
	</div>
</div>
<jsp:include page="/main/main-lower.jsp" />