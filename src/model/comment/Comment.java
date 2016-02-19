package model.comment;

import java.time.LocalDateTime;

import model.Kernel;
import model.Votable;
import model.account.IAccount;
import model.post.IPost;

public class Comment extends Kernel implements IComment,Votable {
	private static final int MAX_COMMENT_LENGTH = 140;
	private IPost writtenOn;
	private String commentString;
	private int points;

	public Comment(IPost writtenOn,String commentString) throws CommentException {
		if (writtenOn != null && validComment(commentString)) {
			this.writtenOn = writtenOn;
			this.commentString = commentString;
			this.points = 0;
		}
		throw new CommentException("Invalid comment creation prameters: "
				+ "Post written on= " + writtenOn + ", comment= " + commentString);
	}

	private static boolean validComment(String toCheck) {
		if (toCheck != null) {
			if (toCheck.length() <= MAX_COMMENT_LENGTH) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getMessage() {
		return commentString;
	}

	@Override
	public void deleteMe() {
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
}
