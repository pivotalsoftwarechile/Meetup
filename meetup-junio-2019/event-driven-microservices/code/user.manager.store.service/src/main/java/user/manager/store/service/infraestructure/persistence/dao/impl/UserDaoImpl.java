package user.manager.store.service.infraestructure.persistence.dao.impl;

import reactor.core.publisher.Mono;
import user.manager.store.service.infraestructure.dto.UserDto;
import user.manager.store.service.infraestructure.persistence.dao.UserDao;
import user.manager.store.service.infraestructure.persistence.mongo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUser(UserDto userDto) {
        boolean isSaved = false;
        try {
            // save user
            Mono<UserDto> newUserDto = userRepository.save(userDto);
            //
            if(newUserDto.blockOptional().isPresent()){
                isSaved = true;
                //
                log.info("[{}] Se ha insertado correctamente el usuario[{}]!!!", UserDaoImpl.class.getSimpleName(), userDto);
            }else{
                if(log.isWarnEnabled()){
                    log.warn("[{}] Ha ocurrido un error en la consistencia de la data al insertar el usuario[{}]!!!", UserDaoImpl.class.getSimpleName(), userDto);
                }
            }
        }catch (Exception e){
            if(log.isErrorEnabled()) {
                log.error("[{}] Ha ocurrido un error al insertar el usuario[{}]!!!", UserDaoImpl.class.getSimpleName(), userDto);
                log.error(e.getMessage(), e);
            }
        }
        return isSaved;
    }
}
