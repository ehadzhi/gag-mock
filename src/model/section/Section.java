package model.section;

public class Section implements ISection {
	private String name;
	
	public Section(String name) throws SectionException {
		if( name != null && !name.equals("")){
			this.name = name;
		}
		else{
			throw new SectionException("Invalid section name: " + name);
		}
	}
	
}
