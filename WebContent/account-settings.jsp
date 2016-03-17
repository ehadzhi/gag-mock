<div class="container">
		<div class="col-lg-4 col-mg-2 col-sg-2" style="padding-left: 5%">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a href="#">Account</a></li>
				<li role="presentation"><a href="settings.jsp?settings=password">Password</a></li>
				<li role="presentation"><a href="#">Profile</a></li>
			</ul>
		</div>

		<div class="col-lg-5 col-mg-2 col-sg-2">
			<h1>Account</h1>
			<form>
				<div class="container-fluid" style="padding-top: 30px">
					<p>Username</p>
					<label for="userName" class="sr-only">Username</label>
					<input type="userName" id="inputUsername" class="form-control" placeholder="Current Username" required autofocus>
				</div>
				<div class="container-fluid" style="padding-top: 30px">
					<p>Email</p>
					<label for="inputEmail" class="sr-only">Email address</label>
					<input type="email" id="inputEmail" class="form-control" placeholder="CurrentEmail" required autofocus>
				</div>
				<div class="container-fluid"  style="padding-top: 30px">
						<div class="input-group">
							<p><input type="checkbox" aria-label="..."> <b> Show NSFW posts</b></p>
					</div><!-- /.col-lg-6 -->
				</div>
				<div class="container-fluid" style="padding-top: 30px">
					<button class="btn btn-primary" type="submit">Save Changes</button>
				</div>
			</form>	
		</div>
	</div>