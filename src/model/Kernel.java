package model;

import java.time.LocalDateTime;

import model.account.IAccount;

public abstract class Kernel implements IKernel {

	private LocalDateTime dateTimeOfCreation;

	public Kernel() {
		this.dateTimeOfCreation = LocalDateTime.now();
	}

	@Override
	public LocalDateTime getDateTimeOfCreation() {
		return dateTimeOfCreation;
	}


}
