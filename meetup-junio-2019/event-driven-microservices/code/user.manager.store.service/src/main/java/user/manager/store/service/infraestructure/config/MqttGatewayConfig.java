package user.manager.store.service.infraestructure.config;

import gps.monitor.cloud.rx.mqtt.client.enums.MessageBusStrategy;
import gps.monitor.cloud.rx.mqtt.client.integration.MqttGateway;
import gps.monitor.cloud.rx.mqtt.client.integration.MqttGatewayBuilder;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import user.manager.store.service.infraestructure.integration.mqtt.EventBusConsumer;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"user.manager.store.service"})
public class MqttGatewayConfig {


    @Bean
    public EventBusConsumer eventBusConsumer(){
        return new EventBusConsumer();
    }

    @Bean
    public MqttGateway mqttGateway() throws MqttException {

        // config mqtt gateway only publish
        return MqttGatewayBuilder.getInstance()
                .with($ -> {
                    $.host = "192.168.99.100";
                    $.port = 1883;
                    $.identifier = "user-manager-store-service";
                })
                .with($ -> {
                    $.debug = false;
                    $.retryAndWait = false; // save attach
                })
                .with($ -> {
                    $.connectOptions = new MqttGatewayBuilder.ConnectOptionsBuilder()
                            .with($cOptions -> {
                                $cOptions.cleanSession = true;
                                $cOptions.keepAliveInterval = 60; //seg
                                $cOptions.automaticReconnect = true;
                                $cOptions.connectionTimeout = 30;
                                $cOptions.maxInflight = 1000;
                            })
                    .createConnectOptions();
                })
                .with($ -> {
                    $.memoryPersistence = true;
                    $.bufferOptions = new MqttGatewayBuilder.BufferOptionsBuilder()
                            .with($bOptions -> {
                                $bOptions.bufferEnabled = false;
                                //$bOptions.bufferSize = 1000;
                                //$bOptions.persistBuffer = true;
                            })
                    .createBufferOptions();
                })
                .with($ -> {
                    $.subscriberBusStrategy = MessageBusStrategy.SECUENCE_STRATEGY; // default strategy
                    $.messageSubscritor = eventBusConsumer(); // consume messages
                    $.subscriberOptions = new MqttGatewayBuilder.SubscriberOptionsBuilder()
                            .with($sOptions -> {
                               $sOptions.topicFilter = "/UserEventBus";
                               $sOptions.qos = 2;
                                })
                    .createSubcriberOptions();
                })
                .create()
        .subscribeWithOptions();
    }
}
