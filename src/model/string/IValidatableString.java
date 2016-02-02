package model.string;

public interface IValidatableString {
	
	IValidatableString getInstance(String toBeValidated);
	
	int getMaxLenght();
	
	String getString();
	
}
