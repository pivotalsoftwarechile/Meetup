package user.manager.store.service.infraestructure.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import user.manager.store.service.application.service.event.CreatedPersonEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class EventConverter {

    public CreatedPersonEvent convert(Byte[] from){
        CreatedPersonEvent to = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            to = objectMapper.readValue( new String(ArrayUtils.toPrimitive(from), StandardCharsets.UTF_8),  CreatedPersonEvent.class);

        } catch (IOException e){
            log.error(e.getMessage(), e);
        }
        return to;
    }


}
