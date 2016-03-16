package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.ErrorInfo;
import jdbc.AccountDAO;
import model.account.Account;
import model.account.AccountException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AccountDAO toRegister = new AccountDAO(new Account(
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("email")));
			

			if (toRegister.checkFreeUsername()) {
				toRegister.insertIntoDataBase();
				response.sendRedirect("/gagmock");
			} else {
				response.sendRedirect(ErrorInfo.USERNAME_TAKEN);
			}
		} catch (AccountException e) {
			response.sendRedirect(ErrorInfo.BAD_PARAMETERS 
		+ e.getMessage().replace(' ', '+'));
		}
	}

}
