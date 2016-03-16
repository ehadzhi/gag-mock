<%@page import="info.Info"%>
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
</head>
<body>
	<header>
		<jsp:include page="navbar.jsp" />
	</header>
	<div class="container">
		<div class="col-lg-12">
			<h1 class="text-center"><%out.print(request.getParameter(Info.ERROR_LABEL)); %></h1>
			<h2 class="text-center">You're going off rails.</h2>
			<img src="images/error.png" class="img-responsive center-block"
				alt="error img">
		</div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>