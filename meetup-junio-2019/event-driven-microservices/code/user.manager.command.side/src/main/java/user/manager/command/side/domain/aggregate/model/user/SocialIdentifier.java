package user.manager.command.side.domain.aggregate.model.user;

public abstract class SocialIdentifier {
		
	protected abstract void assertIfValidIdentifier(String id);
	
	public abstract String getIdentifier();	
}
