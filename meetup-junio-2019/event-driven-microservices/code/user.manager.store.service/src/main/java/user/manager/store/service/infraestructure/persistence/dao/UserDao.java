package user.manager.store.service.infraestructure.persistence.dao;

import user.manager.store.service.infraestructure.dto.UserDto;

public interface UserDao extends Dao {

    boolean saveUser(UserDto userDto);

}
