package model.comment;

import model.post.IPost;

public class Comment implements IComment {
	private static final int MAX_COMMENT_LENGTH = 140;
	private IPost writtenOn;
	private String commentString;
	private int points;

	public Comment(IPost writtenOn, String commentString) throws CommentException {
		if (writtenOn != null && validComment(commentString)) {
			this.writtenOn = writtenOn;
			this.commentString = commentString;
			this.points = 0;
		}
		throw new CommentException("Invalid comment creation prameters: " + "Post written on= " + writtenOn
				+ ", comment= " + commentString);
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
	public int getPoints() {
		return points;
	}

}
