package model.post;

import model.Kernel;
import model.account.Account;
import model.account.IAccount;
import model.comment.Comment;
import model.comment.IComment;

public class Post extends Kernel implements IPost {
	// TODO field : file picture
	private int ID;
	private IAccount creator;
	// TODO commSents are a queue
	private Comment[] comments;
	private int points;
	
	@Override
	public void comment(IComment toAdd) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void comment(IAccount commenter, IComment toAdd) {
		// TODO Auto-generated method stub
		
	}

}
