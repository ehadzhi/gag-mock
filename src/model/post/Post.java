package model.post;

import model.Kernel;
import model.Votable;
import model.account.IAccount;
import model.comment.IComment;

public class Post extends Kernel implements IPost, Votable {
	// TODO field : file picture
	private IAccount creator;
	private String postHeader;
	private int points;

	public Post(IAccount creator, String postHeader) throws PostException {
		if (creator != null && postHeader != null && !postHeader.equals("")) {
			this.creator = creator;
			setPostHeader(postHeader);
		} else {
			throw new PostException(
					"Invalid constructor parabeters : creator= " + creator + ", post header= " + postHeader);
		}
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addComment(IAccount commenter, IComment toAdd) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public boolean upVote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean downVote() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPostHeader() {
		return postHeader;
	}

	public void setPostHeader(String postHeader) throws PostException {
		if (postHeader != null && !postHeader.equals("")) {
			this.postHeader = postHeader;
		} else {
			throw new PostException("Invalid post header : " + postHeader);
		}
	}
}
