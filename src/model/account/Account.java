package model.account;

import java.util.Map;
import java.util.Queue;

import javax.security.auth.login.AccountException;

import model.IKernel;
import model.Kernel;
import model.Votable;
import model.comment.IComment;
import model.post.IPost;
import model.post.Post;
import model.section.ISection;

public class Account extends Kernel implements IAccount {
	private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private static final String USERNAME_REGEX = "^[0-1a-zA-Z_]{3,100}";
	private static final String PASSWORD_REGEX = "[0-9a-zA-Z]{8,100}";

	private String userName;
	private String password;
	private String eMail;
	private boolean showNSFWPosts;
	private boolean genderMale;

	public Account(String userName, String password, String eMail, boolean showNSFWPosts, boolean genderMale)
			throws AccountException {
		setUserName(userName);
		setPassword(password);
		setEMail(eMail);
		this.showNSFWPosts = showNSFWPosts;
		this.genderMale = genderMale;
	}

	@Override
	public boolean upVote(Votable toUpVote) {
		if (toUpVote != null) {
			toUpVote.upVote();
			if (toUpVote instanceof Post) {
				// TODO add Post to voted
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean downVote(Votable toDownVote) {
		if (toDownVote != null) {
			toDownVote.downVote();
			if (toDownVote instanceof Post) {
				// TODO add Post to voted
			}
			return true;
		}
		return false;

	}

	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) throws AccountException {
		if (userName != null && !userName.equals("")) {
			if (validUsername(userName)) {
				this.userName = userName;
			}
			throw new AccountException("userName doesn't match pattern, userName: " + userName);
		}
		throw new AccountException("userName is a null or \"\" " + userName);
	}

	public static boolean validUsername(String usernameToTest) {
		if (usernameToTest != null && !usernameToTest.equals("")) {
			return usernameToTest.matches(USERNAME_REGEX);
		}
		return false;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) throws AccountException {
		if (password != null && !password.equals("")) {
			if (validPassword(password)) {
				this.password = password;
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

	public String geteMail() {
		return eMail;
	}

	private void setEMail(String eMail) throws AccountException {
		if (eMail != null && !eMail.equals("")) {
			if (validEMail(eMail)) {
				this.eMail = eMail;
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

	public boolean isShowNSFWPosts() {
		return showNSFWPosts;
	}

	private void setShowNSFWPosts(boolean showNSFWPosts) {
		this.showNSFWPosts = showNSFWPosts;
	}

	public boolean isGenderMale() {
		return genderMale;
	}

	@Override
	public boolean deleteMyCreation(IKernel toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

}
