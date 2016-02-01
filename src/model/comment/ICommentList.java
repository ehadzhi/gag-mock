package model.comment;

import java.util.Iterator;

public interface ICommentList {
	
	boolean addComment(IComment toAdd);
	
	boolean deleteComment(IComment toDelete);
	
	Iterator<IComment> getCommentsIterator();
	
}
