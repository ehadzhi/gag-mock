<%@page import="info.Info"%>
<ul class="nav navbar-nav navbar-right">
	<li><a data-toggle="modal" data-target=".bs-example-modal-sm"><span
			class="glyphicon glyphicon-upload" aria-hidden="true"></span> Upload</a>
		<div class="modal fade bs-example-modal-sm" tabindex="-1"
			role="dialog" aria-labelledby="mySmallModalLabel">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
						<form action="/gagmock/upload-post" method="post" enctype="multipart/form-data">
							<fieldset class="form-group">
							<h2 class="form-signup-heading">Upload a post</h2>
								<label for="formGroupExampleInput">Enter post name</label> <input
									type="text" name=post_name class="form-control" id="formGroupExampleInput"
									placeholder="Super cool name">
							</fieldset>
							<fieldset class="form-group">
								<label for="exampleInputFile">File input</label> <input
									type="file" name=post_picture class="form-control-file" id="exampleInputFile">
								<small class="text-muted">Please select your post photo from your computer.</small>
							</fieldset>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Create post</button>
						</form>
					</div>
				</div>
			</div>
		</div></li>
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="false"><span class="glyphicon glyphicon-user"
			aria-hidden="true"></span><span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="/gagmock/settings/profile.jsp?user_id=<%out.print(session.getAttribute(Info.ACCOUNT_ID_LABEL));%>">My profile</a></li>
			<li><a href="/gagmock/settings/settings.jsp?settings=account">Settings</a></li>
			<li><a href="/gagmock/error.jsp?error=No+help+for+you">Help</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="/gagmock/logout">Log out</a></li>
		</ul></li>
</ul>