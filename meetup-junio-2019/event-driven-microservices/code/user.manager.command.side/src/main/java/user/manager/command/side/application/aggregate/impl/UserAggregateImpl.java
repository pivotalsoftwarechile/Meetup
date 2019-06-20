package user.manager.command.side.application.aggregate.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.manager.command.side.application.command.CreateGroupCommand;
import user.manager.command.side.application.command.CreateUserCommand;
import user.manager.command.side.application.command.RemoveUserCommand;
import user.manager.command.side.application.command.UpdateUserCommand;
import user.manager.command.side.domain.aggregate.model.user.*;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;

import java.util.Optional;

@Slf4j
@Component
public class UserAggregateImpl extends UserAggregate {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void handle(CreateUserCommand command) {
        Optional<Identifier> identifier = userRepository.getUserId();
        if(identifier.isPresent()){
            // identifier
            UserIdentifier userIdentifier = (UserIdentifier) identifier.get();
            // socialIdentifier
            SocialIdentifier nationalSingleRole = new NationalSingleRole(command.getNationalSingleRole());
            // userType
            Type userType = new Type(new UserTypeIdentifier(UserTypeEnum.PERSON.getTypeId()));
            // person
            User person =
                    makePerson(userIdentifier, // identifier
                               userType, // userType
                               nationalSingleRole, // socialIdentifier
                               command.getFirstName(), // firstName
                               command.getLastName(), // lastName
                               Optional.empty(), // roles
                               Optional.empty()); // geo
            // add the user person
            Optional<User> addPerson = userRepository.addUser(person);
            //
            if(addPerson.isPresent()){
                //TODO return success message
            }else{
                //TODO returns fail success message
            }
        }else{
            //TODO returns fail message
        }
    }

    @Override
    public void handle(CreateGroupCommand command) {
        Optional<Identifier> identifier = userRepository.getUserId();
        if(identifier.isPresent()){
            // identifier
            UserIdentifier userIdentifier = (UserIdentifier) identifier.get();
            // socialIdentifier
            SocialIdentifier nationalSingleRole = new TributarySingleRole(command.getTributarySingleRole());
            // userType
            Type userType = new Type(new UserTypeIdentifier(UserTypeEnum.PARTY_GROUP.getTypeId()));
            // user group
            User group =
                    makeGroup(userIdentifier, // identifier
                              userType, // userType
                              nationalSingleRole, // socialIdentifier
                              command.getGroupName(), // groupName
                              Optional.empty(), // roles
                              Optional.empty()); // geo
            // add the user group
            Optional<User> addGroup = userRepository.addUser(group);
            //
            if(addGroup.isPresent()){
                //TODO return success message
            }else{
                //TODO returns success message
            }
        }else{
            //TODO returns fail message
        }
    }

    public void handle(UpdateUserCommand command) {
        //TODO to implement
    }

    public void handle(RemoveUserCommand command) {
        //TODO to implement
    }
}
