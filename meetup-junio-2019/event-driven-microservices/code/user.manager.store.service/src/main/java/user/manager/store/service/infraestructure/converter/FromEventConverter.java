package user.manager.store.service.infraestructure.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import user.manager.store.service.application.service.event.CreatedPersonEvent;
import user.manager.store.service.infraestructure.dto.UserDto;

import java.util.Objects;


@Slf4j
@Component
public class FromEventConverter implements Converter<CreatedPersonEvent, UserDto> {

    @Override
    public UserDto convert(CreatedPersonEvent from) {
        UserDto to = null;
        try {
            if(Objects.nonNull(from)) {
                to = new UserDto();
                to.setSocialIdentifier(from.getNationalSingleRole());
                to.setFirstName(from.getFirstName());
                to.setLastName(from.getLastName());
            }
        } catch (Exception e){
            if(log.isErrorEnabled()){
                log.error(e.getMessage(), e);

            }
        }
        return to;
    }
}
