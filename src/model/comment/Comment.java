package model.comment;
import java.time.LocalDateTime;

import model.Kernel;
import model.account.Account;
import model.account.IAccount;
import model.post.IPost;
import model.post.Post;

public class Comment extends Kernel implements IComment {
	private LocalDateTime timeOfCreation;
	private Post writtenOn;
	private String commentString;
	private Account writer;
	
	@Override
	public String getMessage() {
		return commentString;
	}
	@Override
	public IPost getOriginPost() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
}
