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
}
