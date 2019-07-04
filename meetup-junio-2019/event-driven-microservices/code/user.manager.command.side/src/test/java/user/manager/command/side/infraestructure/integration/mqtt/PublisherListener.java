package user.manager.command.side.infraestructure.integration.mqtt;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import lombok.extern.slf4j.Slf4j;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class PublisherListener extends AbstractInterceptHandler {

    @Override
    public String getID() {
        return "EmbeddedLauncherPublishListener";
    }

    @Override
    public void onPublish(InterceptPublishMessage message) {
        final String decodedPayload = new String(message.toString().getBytes(), UTF_8);
        log.info(String.format("Received on topic: [{}] | content: [{}]", message.getTopicName(), decodedPayload));
    }
}
