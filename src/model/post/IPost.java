package model.post;

import model.IKernel;
import model.account.IAccount;
import model.comment.IComment;

public interface IPost extends IKernel {
	
	// getComments
	
	void comment(IComment toAdd);
	
	boolean delete();
	
	void comment(IAccount commenter,IComment toAdd);
}
