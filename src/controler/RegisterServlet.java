package controler;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionSingleton;
import model.account.Account;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final String CREATE_ACCOUNT = "insert into account values (null,?,?,?,now());";
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (validate(username, password, email)) {
			if (checkFreeUsername(username)) {
				Connection conn = ConnectionSingleton.getConnection();
				try {
					PreparedStatement prep = conn.prepareStatement(CREATE_ACCOUNT);
					prep.setString(1, username);
					prep.setString(2, email);
					prep.setString(3, password);
					prep.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				throw new ServletException("An account with this username already exists: " + username);
			}
		} else {
			throw new ServletException("Invalid register parameters (username,email,password)=(" + username + ", "
					+ email + ", " + password + ")");
		}
	}

	private static boolean validate(String username, String password, String eMail) {
		if (!Account.validUsername(username)) {
			System.out.println("Inavalid username: " + username);
			return false;
		}
		if (!Account.validEMail(eMail)) {
			System.out.println("Inavalid eMail: " + eMail);
			return false;
		}
		if (!Account.validPassword(password)) {
			System.out.println("Inavalid passsword: " + password);
			return false;
		}
		return true;
	}

	private static boolean checkFreeUsername(String candidateUsername) {
		System.out.println("predi getConnection");
		Connection conn = ConnectionSingleton.getConnection();
		System.out.println("sled tva");
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT username FROM Account WHERE username = '" + candidateUsername + "'";
			if (stmt.executeQuery(sql).next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
