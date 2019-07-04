package user.manager.command.side.infraestructure.config;

import gps.monitor.cloud.rx.mqtt.client.integration.MqttGateway;
import gps.monitor.cloud.rx.mqtt.client.integration.MqttGatewayBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"vehicle.manager.command.side"})
public class MqttGatewayConfig {

    @Bean
    public MqttGateway mqttGateway(){
        // config mqtt gateway only publish
        return MqttGatewayBuilder.getInstance()
                .with($ -> {
                    $.host = "192.168.99.100";
                    $.port = 1883;
                    $.identifier = "user-manager-command-side";
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
                    $.publisherOptions = new MqttGatewayBuilder.PublisherOptionsBuilder()
                            .with($pOptions -> {
                                $pOptions.topicFilter = "/UserEventBus";
                                $pOptions.qos = 0;
                                $pOptions.retained = false;
                            })
                            .createPublisherOptions();
                })
                .create();
    }
}
