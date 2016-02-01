package model.account;

import java.util.TreeMap;

public class AccountDataBase implements IAccountDataBase {

	private static IAccountDataBase dataBase;
	private static TreeMap<String, IAccount> container;
	
	private AccountDataBase() {
		// TODO Singleton
	}
	
	@Override
	public IAccount createAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAccount getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IAccountDataBase getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
