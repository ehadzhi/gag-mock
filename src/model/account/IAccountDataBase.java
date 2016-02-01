package model.account;

public interface IAccountDataBase {
	
	IAccount createAccount(String username); // TODO add more parameters
	
	IAccount getAccount(String username);
	
	boolean deleteAccount(String username);
	
	IAccountDataBase getInstance();
}
