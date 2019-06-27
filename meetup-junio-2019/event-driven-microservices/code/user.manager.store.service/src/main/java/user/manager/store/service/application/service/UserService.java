package user.manager.store.service.application.service;

import user.manager.store.service.application.service.event.CreatedGroupEvent;
import user.manager.store.service.application.service.event.CreatedPersonEvent;

public interface UserService extends Service {

    boolean store(CreatedPersonEvent event);

    boolean store(CreatedGroupEvent event);

}
