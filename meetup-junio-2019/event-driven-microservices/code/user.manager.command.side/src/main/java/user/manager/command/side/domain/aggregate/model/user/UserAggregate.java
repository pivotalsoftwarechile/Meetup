package user.manager.command.side.domain.aggregate.model.user;
import user.manager.command.side.application.aggregate.Aggregate;
import user.manager.command.side.application.command.CreateUserCommand;
import user.manager.command.side.application.command.RemoveUserCommand;
import user.manager.command.side.application.command.UpdateUserCommand;
import java.util.List;
import java.util.Optional;

public abstract class UserAggregate implements Aggregate {

    public void handle(CreateUserCommand command) {
    }

    public void handle(UpdateUserCommand command) {
    }

    public void handle(RemoveUserCommand command) {
    }

    public User makeUser(Identifier userId, SocialIdentifier socialIdentifier, String firstName, String lastName) {
        return new User(userId, socialIdentifier, firstName, lastName, Optional.empty(), Optional.empty());
    }

    public User makeUser(Identifier userId, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles) {
        return new User(userId, socialIdentifier, firstName, lastName, roles, Optional.empty());
    }

    public User makeUser(Identifier userId, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles, Optional<Geo> geo) {
        return new User(userId, socialIdentifier, firstName, lastName, roles, geo);
    }

    public Role makeRole(Identifier id, String roleType, String roleDescription)  {
        Type producerRoleType = new Type(new Identifier(roleType));
        Role producerRole = new Role(id, producerRoleType, roleDescription);
        return producerRole;
    }

    public Geo makeGeographicUbication(Identifier geoId, Location city, Location comune, Location province, Location region, Location country) {
        return new Geo(geoId, city, comune, province, region, country, Optional.empty(), Optional.empty());
    }

    public Geo makeGeographicUbication(Identifier geoId, Location city, Location comune, Location province, Location region, Location country, Optional<Double> latitude, Optional<Double> longitude) {
        return new Geo(geoId, city, comune, province, region, country, latitude, longitude);
    }
}