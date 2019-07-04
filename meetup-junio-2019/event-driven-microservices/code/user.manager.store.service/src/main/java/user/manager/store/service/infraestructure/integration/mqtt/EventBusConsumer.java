package user.manager.store.service.infraestructure.integration.mqtt;

import gps.monitor.cloud.rx.mqtt.client.message.MessageWrapper;
import gps.monitor.cloud.rx.mqtt.client.subscriber.MessageConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import user.manager.store.service.application.service.UserService;
import user.manager.store.service.application.service.event.CreatedPersonEvent;
import user.manager.store.service.infraestructure.converter.EventConverter;

import java.nio.charset.StandardCharsets;

@Slf4j
public class EventBusConsumer implements MessageConsumer<MessageWrapper> {

    @Autowired
    private UserService userService;

    @Autowired
    private EventConverter converter;

    @Override
    public void accept(MessageWrapper message) {
        try {
            if (!message.isDuplicate()) {
                //
                log.info("[{}] Recepcion del message[{}] desde el topico [{}]",
                        EventBusConsumer.class.getSimpleName(), new String(message.getPayload(), StandardCharsets.UTF_8), message.getTopicFilter());

                CreatedPersonEvent createdPersonEvent = converter.convert(ArrayUtils.toObject(message.getPayload()));
                userService.store(createdPersonEvent);


            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
