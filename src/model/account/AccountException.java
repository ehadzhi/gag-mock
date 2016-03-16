package model.account;

public class AccountException extends Exception {

	private static final long serialVersionUID = -4480443078706424802L;

	public AccountException() {
	}

	public AccountException(String arg0) {
		super(arg0);
	}

	public AccountException(Throwable arg0) {
		super(arg0);
	}

	public AccountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AccountException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
