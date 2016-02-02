package model.string;

public abstract class ValidatableString implements IValidatableString{
	private String value;
	
	public ValidatableString(String toBeValidated) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getString() {
		return value;
	}
}
