package model.post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import jdbc.ConnectionDispatcher;
import model.account.IAccount;
import model.comment.IComment;

public class Post implements IPost {
	private static AtomicInteger numPosts;
	private String pictutePath;
	private int creatorID;
	private String postHeader;
	private int points;
	
	static{
		Connection conn = ConnectionDispatcher.getConnection();
		try {
			ResultSet res = conn.createStatement()
			.executeQuery("select count(post_id) from post;");
			res.next();
			numPosts = new AtomicInteger(res.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Post(int creatorID, String postHeader, String picturePath)
			throws PostException {
		if (validate(creatorID, postHeader, picturePath)) {
			this.creatorID = creatorID;
			this.pictutePath = "/post/img" 
			+ numPosts.incrementAndGet() 
			+ picturePath.substring(picturePath.lastIndexOf('.'));
			setPostHeader(postHeader);
		} else {
			throw new PostException(
					"Invalid constructor parabeters : creator= " + creatorID + ", post header= " + postHeader);
		}
	}

	private boolean validate(int creatorID, String postHeader, String picturePath) {
		return creatorID > 0 && postHeader != null && !postHeader.equals("") 
				&& picturePath != null && !picturePath.equals("");
	}

	@Override
	public int getCreatorID() {
		return creatorID;
	}

	@Override
	public String getPictutePath() {
		return pictutePath;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public String getPostHeader() {
		return postHeader;
	}

	@Override
	public void setPostHeader(String postHeader) throws PostException {
		if (postHeader != null && !postHeader.equals("")) {
			this.postHeader = postHeader;
		} else {
			throw new PostException("Invalid post header : " + postHeader);
		}
	}
}
