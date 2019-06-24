package user.manager.command.side.domain.aggregate.model.user;
import user.manager.command.side.application.aggregate.Aggregate;
import user.manager.command.side.application.command.*;

import java.util.List;
import java.util.Optional;

public abstract class UserAggregate implements Aggregate {

    public void handle(CreateUserCommand command) {
    }

    public void handle(UpdateUserCommand command) {
    }

    public void handle(RemoveUserCommand command) {
    }

    public void handle(CreateGroupCommand command) {
    }

    public void handle(UpdateGroupCommand command) {
    }

    public void handle(RemoveGroupCommand command) {
    }

    public User makePerson(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String firstName, String lastName) {
        return new User(userId, userType, socialIdentifier, firstName, lastName, Optional.empty(), Optional.empty());
    }

    public User makePerson(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles) {
        return new User(userId, userType, socialIdentifier, firstName, lastName, roles, Optional.empty());
    }

    public User makePerson(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String firstName, String lastName, Optional<List<Role>> roles, Optional<Geo> geo) {
        return new User(userId, userType, socialIdentifier, firstName, lastName, roles, geo);
    }

    public User makeGroup(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String groupName) {
        return new User(userId, userType, socialIdentifier, groupName, Optional.empty(), Optional.empty());
    }

    public User makeGroup(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String groupName, Optional<List<Role>> roles) {
        return new User(userId, userType, socialIdentifier, groupName, roles, Optional.empty());
    }

    public User makeGroup(Identifier userId, Type userType, SocialIdentifier socialIdentifier, String groupName, Optional<List<Role>> roles, Optional<Geo> geo) {
        return new User(userId, userType, socialIdentifier, groupName, roles, geo);
    }

    public Role makeRole(UserTypeIdentifier id, String roleType, String roleDescription)  {
        Type userRoleType = new Type(id);
        Role userRole = new Role(id, userRoleType, roleDescription);
        return userRole;
    }

    public Geo makeGeographicUbication(Identifier geoId, Location city, Location comune, Location province, Location region, Location country) {
        return new Geo(geoId, city, comune, province, region, country, Optional.empty(), Optional.empty());
    }

    public Geo makeGeographicUbication(Identifier geoId, Location city, Location comune, Location province, Location region, Location country, Optional<Double> latitude, Optional<Double> longitude) {
        return new Geo(geoId, city, comune, province, region, country, latitude, longitude);
    }


    /*public void onEvent(UserCreated event){

    }*/
}