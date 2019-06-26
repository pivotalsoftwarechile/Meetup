package user.manager.command.side.infraestructure;

import gps.monitor.cloud.rx.mqtt.client.integration.MqttGateway;
import gps.monitor.cloud.rx.mqtt.client.integration.MqttGatewayBuilder;
import io.moquette.interception.InterceptHandler;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathResourceLoader;
import io.moquette.server.config.IConfig;
import io.moquette.server.config.IResourceLoader;
import io.moquette.server.config.ResourceLoaderConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import user.manager.command.side.infraestructure.integration.mqtt.PublisherListener;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"vehicle.manager.command.side"})
public class MqttGatewayTestConfig {

    @Bean("mqttServer")
    public Server mqttServer() throws IOException {
        Server mqttBroker;
        IResourceLoader classpathLoader = new ClasspathResourceLoader();
        //
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);
        mqttBroker = new Server();
        List<? extends InterceptHandler> userHandlers = Collections.singletonList(new PublisherListener());
        mqttBroker.startServer(classPathConfig, userHandlers);

        return mqttBroker;
    }

    @Bean
    @DependsOn("mqttServer")
    public MqttGateway mqttGateway(){
        // config mqtt gateway only publish
        return MqttGatewayBuilder.getInstance()
                .with($ -> {
                    $.host = "127.0.0.1";
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
