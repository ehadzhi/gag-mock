package model.comment;

import model.IKernel;
import model.post.IPost;

public interface IComment extends IKernel {
	
	String getMessage();
	
	IPost getOriginPost();
}
