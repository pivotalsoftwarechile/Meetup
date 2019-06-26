package user.manager.command.side.application.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import user.manager.command.side.domain.aggregate.model.user.Identifier;
import user.manager.command.side.domain.aggregate.model.user.User;
import user.manager.command.side.domain.aggregate.model.user.UserRepository;
import user.manager.command.side.domain.aggregate.model.user.UserTypeIdentifier;
import user.manager.command.side.infraestructure.converter.IdentifierConverter;
import user.manager.command.side.infraestructure.converter.FromUserConverter;
import user.manager.command.side.infraestructure.dto.PartyDto;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;
import user.manager.command.side.infraestructure.persistence.mybatis.dao.PartyDao;

import java.util.Optional;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private PartyDao partyDao;

    @Autowired
    IdentifierConverter identifierConverter;

    @Autowired
    private FromUserConverter fromUserConverter;


    @Override
    public Optional<Identifier> getUserId() {
        return identifierConverter.convert(partyDao.nexValueForIdentifier());
    }


    @Override
    public Optional<User> addUser(User user) {
        Optional<User> newUser = Optional.empty();
        //
        boolean isAdd;
        UserTypeIdentifier userTypeIdentifier = (UserTypeIdentifier) user.getUserType().getTypeId();
        if (UserTypeEnum.PERSON.getTypeId().equals(userTypeIdentifier.getIdentifier())) {
            PartyDto partyDto = fromUserConverter.convert(user);
            // TODO add transactional operation
            isAdd = partyDao.saveParty(partyDto);
            if (isAdd) {
                partyDao.savePerson(partyDto);
                //
                newUser = Optional.of(user);
            }
        } else {
            PartyDto partyDto = fromUserConverter.convert(user);
            // TODO add transactional operation
            isAdd = partyDao.saveParty(partyDto);
            if (isAdd) {
                partyDao.saveGroup(partyDto);
                //
                newUser = Optional.of(user);
            }
        }
        return newUser;
    }

    @Override
    public Optional<User> editUser(User user) {  //TODO to implement
        return Optional.empty();
    }

    @Override
    public Optional<User> removeUser(User user) { //TODO to implement
        return Optional.empty();
    }
}
