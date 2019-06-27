package user.manager.store.service.application.service.impl;

import user.manager.store.service.application.service.UserService;
import user.manager.store.service.application.service.event.CreatedGroupEvent;
import user.manager.store.service.application.service.event.CreatedPersonEvent;
import user.manager.store.service.infraestructure.converter.FromEventConverter;
import user.manager.store.service.infraestructure.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private FromEventConverter converter;

  @Override
  public boolean store(CreatedPersonEvent event) {
    return userDao.saveUser(converter.convert(event));
  }

  @Override
  public boolean store(CreatedGroupEvent event) {
    //TODO to define
    return false;
  }
}
