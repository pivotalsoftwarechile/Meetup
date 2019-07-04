package user.manager.command.side.infraestructure.bus;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.manager.command.side.application.aggregate.impl.UserAggregateImpl;
import user.manager.command.side.application.command.CreateGroupCommand;
import user.manager.command.side.application.command.CreateUserCommand;

@Slf4j
@Component
public class CommandBus implements Bus {

    @Autowired
    private UserAggregateImpl userAggregate;


    public void handle(CreateUserCommand command){
        userAggregate.handle(command);
    }

    public void handle(CreateGroupCommand command){
        userAggregate.handle(command);
    }
}
