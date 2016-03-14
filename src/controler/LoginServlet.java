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

import jdbc.ConnectionSingleton;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String SELECT_PASS = "select account_id,password from account where email = ?;";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Connection conn = ConnectionSingleton.getConnection();

		try {
			PreparedStatement stmnt = conn.prepareStatement(SELECT_PASS);
			stmnt.setString(1, email);
			ResultSet result = stmnt.executeQuery();
			if (result.next() && result.getString("password").equals(password)) {
				session.setAttribute("loggedin", "true");
				session.setAttribute("userid", result.getInt("account_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/gagmock/main.jsp");

	}
}
