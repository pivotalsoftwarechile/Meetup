package user.manager.command.side.application.aggregate.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import user.manager.command.side.application.command.CreateGroupCommand;
import user.manager.command.side.application.command.CreateUserCommand;
import user.manager.command.side.application.event.CreatedPersonEvent;
import user.manager.command.side.domain.aggregate.model.user.*;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;
import user.manager.command.side.infraestructure.handler.EventHandler;

import java.util.Optional;

@Slf4j
@Component
public class UserAggregateImpl extends UserAggregate {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventHandler eventHandler;


    @Override
    @Transactional
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
                onEvent(new CreatedPersonEvent(
                        addPerson.get().getSocialIdentifier().getIdentifier(), addPerson.get().getFirstName(), addPerson.get().getLastName()));

                //TODO return success message
            }else{
                //TODO returns fail message
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
            SocialIdentifier tributarySingleRole = new TributarySingleRole(command.getTributarySingleRole());
            // userType
            Type userType = new Type(new UserTypeIdentifier(UserTypeEnum.PARTY_GROUP.getTypeId()));
            // user group
            User group =
                    makeGroup(userIdentifier, // identifier
                              userType, // userType
                              tributarySingleRole, // socialIdentifier
                              command.getGroupName(), // groupName
                              Optional.empty(), // roles
                              Optional.empty()); // geo
            // add the user group
            Optional<User> addGroup = userRepository.addUser(group);
            //
            if(addGroup.isPresent()){
                //TODO return success message
            }else{
                //TODO returns fail message
            }
        }else{
            //TODO returns fail message
        }
    }


    @Override
    public void onEvent(CreatedPersonEvent event){
        eventHandler.handler(event);
    }
}
