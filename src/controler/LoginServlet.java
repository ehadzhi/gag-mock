package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.ErrorInfo;
import info.Info;
import jdbc.ConnectionDispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String SELECT_PASS = "select account_id,"
			+ "password,username from account where email = ?;";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter(Info.EMAIL_LABEL);
		String password = request.getParameter(Info.PASSWORD_LABEL);
		HttpSession session = request.getSession();
		Connection conn = ConnectionDispatcher.getConnection();

		try {
			PreparedStatement stmnt = conn.prepareStatement(SELECT_PASS);
			stmnt.setString(1, email);
			ResultSet result = stmnt.executeQuery();
			if (result.next() && result.getString(Info.PASSWORD_LABEL).equals(password)) {
				session.setAttribute(Info.LOGGED_IN_LABEL, "true");
				session.setAttribute(Info.ACCOUNT_ID_LABEL, result.getInt(Info.ACCOUNT_ID_LABEL));
				session.setAttribute(Info.USER_LABEL, result.getString(Info.USER_LABEL));
				session.setAttribute(Info.EMAIL_LABEL, email);
				session.setMaxInactiveInterval(-1);
				response.sendRedirect("/gagmock");
			}
			else{
				response.sendRedirect(ErrorInfo.BAD_LOGIN);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
