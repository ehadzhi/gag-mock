package model;

import java.time.LocalDateTime;

import model.account.IAccount;

public interface IKernel {

	LocalDateTime getDateTimeOfCreation();
	
	IAccount getCreator();
	
	boolean deleteMe(IAccount whoDeletesMe);
	
	boolean hasFullAccess(IAccount toCheck);
}
