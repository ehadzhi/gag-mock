package model.post;

import java.util.Iterator;

import model.IKernel;
import model.account.IAccount;
import model.comment.IComment;
import model.comment.ICommentList;

public interface IPost extends IKernel {
	
	Iterator<ICommentList> getCommentsIterator();
	
	boolean delete();
	
	void addComment(IAccount commenter,IComment toAdd);
	
	int getID();
}
