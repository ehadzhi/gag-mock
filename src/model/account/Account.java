package model.account;

public class Account implements IAccount {
	private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private static final String USERNAME_REGEX = "^[0-9a-zA-Z]{3,100}";
	private static final String PASSWORD_REGEX = "[0-9a-zA-Z]{3,100}";

	private String userName;
	private String password;
	private String eMail;

	public Account(String userName, String password, String eMail) throws AccountException {
		setUserName(userName);
		setPassword(password);
		setEMail(eMail);
	}

	


	@Override
	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) throws AccountException {
		if (userName != null && !userName.equals("")) {
			if (validUsername(userName)) {
				this.userName = userName;
				return;
			} else {
				throw new AccountException("username doesn't match pattern, username: " + userName);
			}
		}
		throw new AccountException("username is a null or \"\" " + userName);
	}

	public static boolean validUsername(String usernameToTest) {
		if (usernameToTest != null && !usernameToTest.equals("")) {
			return usernameToTest.matches(USERNAME_REGEX);
		}
		return false;
	}

	@Override
	public String getPassword() {
		return password;
	}

	private void setPassword(String password) throws AccountException {
		if (password != null && !password.equals("")) {
			if (validPassword(password)) {
				this.password = password;
				return;
			}
			throw new AccountException("Password doesn't match pattern, password: " + password);
		}
		throw new AccountException("Password is a null or \"\" " + password);
	}

	public static boolean validPassword(String passToTest) {
		if (passToTest != null && !passToTest.equals("")) {
			return passToTest.matches(PASSWORD_REGEX);
		}
		return false;
	}

	@Override
	public String geteMail() {
		return eMail;
	}

	private void setEMail(String eMail) throws AccountException {
		if (eMail != null && !eMail.equals("")) {
			if (validEMail(eMail)) {
				this.eMail = eMail;
				return;
			}
			throw new AccountException("Email doesn't match pattern, email: " + eMail);
		}
		throw new AccountException("Email is a null or \"\" " + eMail);
	}

	public static boolean validEMail(String mailToTest) {
		if (mailToTest != null && !mailToTest.equals("")) {
			return mailToTest.matches(EMAIL_REGEX);
		}
		return false;
	}


}
