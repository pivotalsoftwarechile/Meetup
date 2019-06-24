package user.manager.command.side.infraestructure.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import user.manager.command.side.application.event.CreatedUserEvent;
import user.manager.command.side.infraestructure.config.UserCommandSideConfig;

/**
 * Created by daniel.carvajal
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserCommandSideConfig.class})
public class EventHandlerITest {

    @Autowired
    private EventHandler eventHandler;

    @Test
    public void testSendCreatedUserEvent()  {
        //
        CreatedUserEvent createdUserEvent =
                new CreatedUserEvent("11111111-1",
                                     "Bart",
                                      "Simpsom");
        eventHandler.handler(createdUserEvent);
    }
}
