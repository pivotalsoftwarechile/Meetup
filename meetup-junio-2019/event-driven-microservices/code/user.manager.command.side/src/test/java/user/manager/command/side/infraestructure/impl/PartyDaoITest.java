package user.manager.command.side.infraestructure.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import user.manager.command.side.infraestructure.config.UserCommandSideConfig;
import user.manager.command.side.infraestructure.dto.PartyDto;
import user.manager.command.side.infraestructure.enums.UserStatusEnum;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;
import user.manager.command.side.infraestructure.persistence.mybatis.dao.PartyDao;

import java.util.Date;


/**
 * Created by daniel.carvajal
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserCommandSideConfig.class})
public class PartyDaoITest {

    @Autowired
    private PartyDao partyDao;

    @Test
    public void nexValueForIdentifierOK()  {
        //
        long identifier = partyDao.nexValueForIdentifier();
        Assert.assertTrue(identifier > 0);
    }

    @Test
    public void savePartyPerson()  {
        //
        long partyId = partyDao.nexValueForIdentifier();
        Assert.assertTrue(partyId > 0);

        PartyDto partyDto = new PartyDto();
        partyDto.setPartyId(partyId);
        partyDto.setSocialIdentifier("111111111");
        partyDto.setFirstName("Bart");
        partyDto.setLastName("Simpson");
        partyDto.setPartyType(UserTypeEnum.PERSON.getTypeId());
        partyDto.setDescription("Personaje de la serie los Simpson");
        partyDto.setStatusId(UserStatusEnum.ENABLED.getStatusId());
        //
        partyDto.setCreatedDate(new Date());
        partyDto.setCreateByUserLogin("dcarvajal");
        partyDto.setLastModifiedDate(new Date());
        partyDto.setLastModifiedByUserLogin("dcarvajal");

        boolean isSaved = partyDao.saveParty(partyDto);
        Assert.assertTrue(isSaved);
        boolean isSavedPerson = partyDao.savePerson(partyDto);
        Assert.assertTrue(isSavedPerson);
    }

    @Test
    public void savePartyGroup()  {
        //
        long partyId = partyDao.nexValueForIdentifier();
        Assert.assertTrue(partyId > 0);

        PartyDto partyDto = new PartyDto();
        partyDto.setPartyId(partyId);
        partyDto.setSocialIdentifier("111111111");
        partyDto.setGroupName("El bar de Moe");
        partyDto.setPartyType(UserTypeEnum.PARTY_GROUP.getTypeId());
        partyDto.setDescription("El bar de Homero :-)");
        partyDto.setStatusId(UserStatusEnum.ENABLED.getStatusId());
        //
        partyDto.setCreatedDate(new Date());
        partyDto.setCreateByUserLogin("dcarvajal");
        partyDto.setLastModifiedDate(new Date());
        partyDto.setLastModifiedByUserLogin("dcarvajal");

        boolean isSaved = partyDao.saveParty(partyDto);
        Assert.assertTrue(isSaved);
        boolean isSavedPerson = partyDao.saveGroup(partyDto);
        Assert.assertTrue(isSavedPerson);
    }


}
