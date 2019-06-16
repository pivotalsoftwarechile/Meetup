package user.manager.command.side.domain.aggregate.model.user;

import lombok.Value;

@Value
public class Identifier {
	
	private final String id;	
	
	public Identifier(String id) {
		assertNotNull(id);
		//
		this.id = new String(id);
	}
	
	private void assertNotNull(String id) {
		if(Integer.valueOf(id) < 0) {
			throw new IllegalArgumentException("identifier can not be null");
		}
	}	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {	
		return new Identifier(id);
	}
}
