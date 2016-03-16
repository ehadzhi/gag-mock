package jdbc;

import java.sql.*;

import model.account.IAccount;


public class AccountDAO {
	private static final String CHECK_USERNAME = "SELECT username FROM Account WHERE username = ?";
	private static final String CREATE_ACCOUNT = "insert into account values (null,?,?,?,now()"
			+ ",'/images/avatar/avatar_default.jpg');";
	private IAccount account;
	
	public void insertIntoDataBase(){
		Connection conn = ConnectionDispatcher.getConnection();
		PreparedStatement prep;
		try {
			prep = conn.prepareStatement(CREATE_ACCOUNT);
		prep.setString(1, account.getUserName());
		prep.setString(2, account.geteMail());
		prep.setString(3, account.getPassword());
		prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkFreeUsername() {
		Connection conn = ConnectionDispatcher.getConnection();
		PreparedStatement stmnt;
		try {
			stmnt = conn.prepareStatement(CHECK_USERNAME);
			stmnt.setString(1, account.getUserName());
			if (stmnt.executeQuery().next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public AccountDAO(IAccount account) {
		if( account != null){
			this.account = account;
		}
	}

}
