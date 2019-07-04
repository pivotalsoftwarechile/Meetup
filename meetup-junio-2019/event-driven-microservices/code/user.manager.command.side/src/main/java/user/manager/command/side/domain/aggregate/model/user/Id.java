package user.manager.command.side.domain.aggregate.model.user;

public interface Id {
		
	void assertIfValidIdentifier(String id);

	void assertIfValidIdentifier(Long id);

}
