package user.manager.store.service.infraestructure.persistence.dao.impl;

import org.junit.Assert;
import user.manager.store.service.infraestructure.config.UserStoreConfig;
import user.manager.store.service.infraestructure.dto.UserDto;
import user.manager.store.service.infraestructure.persistence.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by daniel.carvajal on 10-12-2018.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserStoreConfig.class})
public class UserDaoITest {

    @Autowired
    private UserDao userDao;

    @Test
    public void storeEvent() {
        UserDto userDto = new UserDto();
        userDto.setSocialIdentifier("1111111-1");
        userDto.setFirstName("Bart");
        userDto.setLastName("Simpson");
        //
        boolean isSaved = userDao.saveUser(userDto);

        Assert.assertTrue(isSaved);
    }
}
