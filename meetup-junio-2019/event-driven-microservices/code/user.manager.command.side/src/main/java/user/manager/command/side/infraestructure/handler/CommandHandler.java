package user.manager.command.side.infraestructure.handler;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import user.manager.command.side.application.command.CreateUserCommand;

@Component
public class CommandHandler {

	@Transactional
	public void handler(CreateUserCommand command) {
		
	}

}
