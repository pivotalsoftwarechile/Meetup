package user.manager.command.side.application.repository.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import user.manager.command.side.domain.aggregate.model.user.*;
import user.manager.command.side.infraestructure.config.UserCommandSideConfig;
import user.manager.command.side.infraestructure.dto.PartyDto;
import user.manager.command.side.infraestructure.enums.UserStatusEnum;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;
import user.manager.command.side.infraestructure.persistence.mybatis.dao.PartyDao;

import java.util.Date;
import java.util.Optional;


/**
 * Created by daniel.carvajal
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserCommandSideConfig.class})
public class UserRepositoryITest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUseId() {
        Optional<Identifier> identifier = userRepository.getUserId();
        Assert.assertTrue(identifier.isPresent());
    }

    @Test
    public void addPerson() {
        // identifier
        Optional<Identifier> identifier = userRepository.getUserId();
        Assert.assertTrue(identifier.isPresent());
        UserIdentifier userIdentifier = (UserIdentifier) identifier.get();

        // userType
        Type userType = new Type(new UserTypeIdentifier(UserTypeEnum.PERSON.getTypeId()));

        // socialIdentifier
        SocialIdentifier nationalSingleRole = new NationalSingleRole("11111111-1");

        User user = new User(userIdentifier, // identifier
                             userType, // userType
                             nationalSingleRole, // socialIdentifier
                            "Bart", // firstName
                            "Simpson", // lastName
                             Optional.empty(), // roles
                             Optional.empty()); // geo
        // add the user person
        Optional<User> addUser = userRepository.addUser(user);
        Assert.assertTrue(addUser.isPresent());
    }

    @Test
    public void addGroup() {
        // identifier
        Optional<Identifier> identifier = userRepository.getUserId();
        Assert.assertTrue(identifier.isPresent());
        UserIdentifier userIdentifier = (UserIdentifier) identifier.get();

        // userType
        Type userType = new Type(new UserTypeIdentifier(UserTypeEnum.PARTY_GROUP.getTypeId()));

        // socialIdentifier
        SocialIdentifier nationalSingleRole = new TributarySingleRole("11111111-1");

        User user = new User(userIdentifier, // identifier
                userType, // userType
                nationalSingleRole, // socialIdentifier
                "El bar de Moe", // groupName
                Optional.empty(), // roles
                Optional.empty()); // geo
        // add the user person
        Optional<User> addUser = userRepository.addUser(user);
        Assert.assertTrue(addUser.isPresent());
    }
}
