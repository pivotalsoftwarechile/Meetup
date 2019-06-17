package user.manager.command.side.application.aggregate.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.manager.command.side.application.command.CreateUserCommand;
import user.manager.command.side.application.command.RemoveUserCommand;
import user.manager.command.side.application.command.UpdateUserCommand;
import user.manager.command.side.domain.aggregate.model.user.UserAggregate;
import user.manager.command.side.domain.aggregate.model.user.UserRepository;

@Slf4j
@Component
public class UserAggregateImpl extends UserAggregate {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void handle(CreateUserCommand command) {
        //TODO to implement
    }

    public void handle(UpdateUserCommand command) {
        //TODO to implement
    }

    public void handle(RemoveUserCommand command) {
        //TODO to implement
    }
}
