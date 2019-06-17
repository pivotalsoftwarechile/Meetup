package user.manager.command.side.domain.aggregate.model.user;

import java.util.List;
import java.util.Optional;

import lombok.Data;


@Data
public class User {

	private final Identifier userId;
	private final SocialIdentifier socialIdentifier; // rut o run
	private final String firstName;
	private final String lastName;
	private final Optional<List<Role>> roles;
	private final Optional<Geo> geo;

	public User(Identifier userId, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles, Optional<Geo> geo) {
		this.userId = userId;
		this.socialIdentifier = socialIdentifier;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.geo = geo;
	}
}
