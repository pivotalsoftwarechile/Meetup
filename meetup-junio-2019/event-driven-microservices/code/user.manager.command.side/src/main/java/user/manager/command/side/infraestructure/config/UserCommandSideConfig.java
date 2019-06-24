package user.manager.command.side.infraestructure.config;

import gps.monitor.cloud.rx.mqtt.client.integration.MqttGateway;
import gps.monitor.cloud.rx.mqtt.client.integration.MqttGatewayBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.UUID;

/**
 *
 * Mantiene la configuracion de la aplicacion y los beans correspondientes.
 *
 * @author daniel.carvajal
 *
 */
@Configuration
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan({"user.manager.command.side"})
@MapperScan({"user.manager.command.side.infraestructure.persistence.mybatis.mapper"})
public class UserCommandSideConfig {

    /**
     * Bean que permite recuperar un datasource
     *
     * @return el datasource
     */
    @Bean
    public DataSource dataSource() {
        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        return  new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2) //.H2
                .addScript("db/h2/sql/schema-hsqldb.sql")
                .addScript("db/h2/sql/data-hsqldb.sql")
        .build();
    }

    @Bean
    public MqttGateway mqttGateway(){
        // config mqtt gateway only publish
        return MqttGatewayBuilder.getInstance()
                .with($ -> {
                    $.host = "127.0.0.1";
                    $.port = 1883;
                    $.identifier = UUID.randomUUID().toString();
                })
                .with($ -> {
                    $.debug = false;
                    $.retryAndWait = true; // save attach
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
                    $.memoryPersistence = false;
                    $.bufferOptions = new MqttGatewayBuilder.BufferOptionsBuilder()
                            .with($bOptions -> {
                                $bOptions.bufferEnabled = true;
                                $bOptions.bufferSize = 1000;
                                $bOptions.persistBuffer = true;
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
