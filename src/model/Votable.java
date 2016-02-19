package model;

public interface Votable extends IKernel {
	
	int getPoints();
	
	boolean upVote();
	
	boolean downVote();
}
