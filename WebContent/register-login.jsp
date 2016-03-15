<ul class="navbar-right navbar-btn">
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target=".bs-example-modal-sm1">Sign up</button>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target=".bs-example-modal-sm">Log in</button>
	<div class="modal fade bs-example-modal-sm1" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<div class="modal-body">
					<form class="form-signup" action="/gagmock/register" method="post">
						<h2 class="form-signup-heading">Please sign up</h2>
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" name="email" id="inputEmail" class="form-control"
							placeholder="Email address" required autofocus> <label
							for="formGroupExampleInput">Username</label> <input
							type="userName" name="username" id="inputUsername"
							class="form-control" placeholder="Username" required autofocus>
						<label for="exampleInputPassword1">Password</label> <input
							type="password" name="password" id="inputPassword"
							class="form-control" placeholder="Password" required>
						<div class="checkbox"></div>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
							up</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<div class="modal-body">
					<form class="form-signin" action="/gagmock/login" method="post">
						<h2 class="form-signin-heading">Please log in</h2>
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" name="email" id="inputEmail" class="form-control"
							placeholder="Email address" required autofocus> <label
							for="exampleInputPassword1">Password</label> <input
							type="password" name="password" id="inputPassword"
							class="form-control" placeholder="Password" required>
						<div class="checkbox">
							<label> <input type="checkbox" value="remember-me">
								Remember me
							</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Log
							in</button>
					</form>
				</div>
			</div>

		</div>

	</div>
</ul>