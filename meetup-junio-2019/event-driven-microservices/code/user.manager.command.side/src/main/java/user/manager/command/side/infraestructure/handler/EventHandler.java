package user.manager.command.side.infraestructure.handler;

import gps.monitor.cloud.rx.mqtt.client.integration.MqttGateway;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.manager.command.side.application.event.CreatedPersonEvent;
import user.manager.command.side.infraestructure.converter.EventConverter;

@Slf4j
@Component
public class EventHandler {

	@Autowired
	private MqttGateway mqttGateway;

	@Autowired
	private EventConverter eventConverter;

	public void handler(CreatedPersonEvent event) {
		try {
			mqttGateway.publishWithOptions(eventConverter.convert(event));

		} catch (MqttException e) {
			log.error(e.getMessage(), e);
		}
	}
}
