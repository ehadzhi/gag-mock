package model.post;

public interface IPost {

	int getCreatorID();

	String getPictutePath();

	void setPoints(int points);

	int getPoints();

	String getPostHeader();

	void setPostHeader(String postHeader) throws PostException;

}