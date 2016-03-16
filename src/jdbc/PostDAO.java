package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.post.*;

public class PostDAO {
	private static final String CREATE_POST = 
			"insert into post values(null,?,1,?,now(),0,?);";
	private IPost post;

	public PostDAO(IPost post) {
		if (post != null) {
			this.post = post;
		}
	}

	public void insertPostInDB() {
		Connection conn = ConnectionDispatcher.getConnection();
		PreparedStatement prep;
		try {
			prep = conn.prepareStatement(CREATE_POST);
			prep.setInt(1, post.getCreatorID());
			prep.setString(2, post.getPostHeader());
			prep.setString(3, post.getPictutePath());
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
