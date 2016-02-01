package model.post;

import model.Kernel;
import model.account.Account;
import model.account.IAccount;
import model.comment.Comment;
import model.comment.IComment;
import model.comment.ICommentList;

public class Post extends Kernel implements IPost {
	// TODO field : file picture
	private final int ID;
	private final IAccount creator;
	// TODO comments are a queue
	private ICommentList comments;
	private int points;
	
	
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addComment(IAccount commenter, IComment toAdd) {
		// TODO Auto-generated method stub
		
	}

}
