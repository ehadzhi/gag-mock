package model;

public interface Votable extends IKernel {
	
	int getScore();
	
	boolean upVote();
	
	boolean downVote();
}
