package model.comment;

import java.time.LocalDateTime;

import model.Kernel;
import model.account.IAccount;
import model.post.IPost;

public class Comment extends Kernel implements IComment {
	private static final int MAX_COMMENT_LENGTH = 140;
	private LocalDateTime dateTimeOfCreation;
	private IPost writtenOn;
	private String commentString;
	private int points;

	public Comment(IAccount creator, IPost writtenOn, String commentString) {
		super(creator);
		if (writtenOn != null && validComment(commentString)) {
			this.dateTimeOfCreation = LocalDateTime.now();
			this.writtenOn = writtenOn;
			this.commentString = commentString;
			this.points = 0;
		}
		// TODO exception
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
	public IPost getOriginPost() {
		return writtenOn;
	}

	@Override
	public boolean deleteMe(IAccount whoDeletesMe) {
		// TODO Auto-generated method stub
		return super.deleteMe(whoDeletesMe);
	}
}
