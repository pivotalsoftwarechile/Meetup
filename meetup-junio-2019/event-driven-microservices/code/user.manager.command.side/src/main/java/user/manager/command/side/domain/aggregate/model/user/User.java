package user.manager.command.side.domain.aggregate.model.user;

import java.util.List;

import lombok.Data;


@Data
public class User {

	private final Identifier producerId;
	private final List<Role> roles;
	private final SocialIdentifier socialIdentifier; // rut o run
	private final String firstName;
	private final String lastName;
	private final Geo geo;

	private User(Identifier producerId, List<Role> roles, SocialIdentifier socialIdentifier, String firstName, String lastName, Geo geo) {
		this.producerId = producerId;		
		this.roles = roles;			
		this.socialIdentifier = socialIdentifier;
		this.firstName = firstName;
		this.lastName = lastName;
		this.geo = geo;
	}

	public User create(Identifier producerId, List<Role> roles, SocialIdentifier socialIdentifier, String firstName, String lastName, Geo geo) {
    	 return new User(producerId, roles, socialIdentifier, firstName, lastName, geo);
    }
	
	public Role makeRole(Identifier id, String roleType, String roleDescription)  {
		Type producerRoleType = new Type(new Identifier(roleType));
		Role producerRole = new Role(id, producerRoleType, roleDescription);
						
		return producerRole;
	}
	
	public Geo makeGeographicUbication(Identifier geoId, Location city, Location comune, Location province, Location region, Location country, Double latitude,Double longitude) {
		return new Geo(geoId, city, comune, province, region, country, latitude, longitude);
	}	
	
}
