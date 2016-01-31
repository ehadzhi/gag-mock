package model;

import java.time.LocalDateTime;

import model.account.IAccount;

public abstract class Kernel implements IKernel {

	private LocalDateTime dateTimeOfCreation;
	private IAccount creator;

	public Kernel(IAccount creator) {
		if (creator != null) {
			this.creator = creator;
		}
		// TODO exception
		this.dateTimeOfCreation = LocalDateTime.now();
	}

	@Override
	public IAccount getCreator() {
		return creator;
	}
	
	@Override
	public LocalDateTime getDateTimeOfCreation() {
		return dateTimeOfCreation;
	}

	@Override
	public boolean hasFullAccess(IAccount toCheck) {
		if (toCheck != null) {
			return creator.equals(toCheck);
		}
		// TODO exception
		return false;
	}

	@Override
	public boolean deleteMe(IAccount whoDeletesMe) {
		if (whoDeletesMe != null) {
			if (hasFullAccess(whoDeletesMe)) {
				// TODO Write delete method
				return true;
			}
		}
		// TODO exception
		return false;
	}

}
