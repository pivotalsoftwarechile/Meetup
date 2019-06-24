package user.manager.command.side.infraestructure.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import user.manager.command.side.application.event.Event;


/**
 * Created by daniel.carvajal on 25-06-2018.
 */
@Slf4j
@Component
public class EventConverter implements Converter<Event, String> {

    @Override
    public String convert(Event event) {
        String to = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            to = objectMapper.writeValueAsString(event);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return to;
    }
}