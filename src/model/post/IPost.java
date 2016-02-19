package model.post;

import model.IKernel;
import model.account.IAccount;
import model.comment.IComment;

public interface IPost extends IKernel {
	
	boolean delete();
	
	void addComment(IAccount commenter,IComment toAdd);
}
