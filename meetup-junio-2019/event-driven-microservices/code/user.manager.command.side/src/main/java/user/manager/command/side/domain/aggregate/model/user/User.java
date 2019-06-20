package user.manager.command.side.domain.aggregate.model.user;

import java.util.List;
import java.util.Optional;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;


@Data
public class User {

	private final Identifier userId;
	private final Type userType;
	private final SocialIdentifier socialIdentifier; // rut o run
	private final String firstName;
	private final String lastName;
	private final String groupName;
	private final Optional<List<Role>> roles;
	private final Optional<Geo> geo;

	public User(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles, Optional<Geo> geo) {
		this.userId = userId;
		this.userType = userType;
		this.socialIdentifier = socialIdentifier;
		this.firstName = firstName;
		this.lastName = lastName;
		//
		this.groupName = Strings.EMPTY;
		this.roles = roles;
		this.geo = geo;
	}

	public User(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String groupName, Optional<List<Role>> roles, Optional<Geo> geo) {
		this.userId = userId;
		this.userType = userType;
		this.socialIdentifier = socialIdentifier;
		this.groupName = groupName;
		//
		this.firstName = Strings.EMPTY;
		this.lastName = Strings.EMPTY;
		this.roles = roles;
		this.geo = geo;
	}
}
