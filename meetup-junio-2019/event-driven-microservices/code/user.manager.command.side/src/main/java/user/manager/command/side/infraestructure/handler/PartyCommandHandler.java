package user.manager.command.side.infraestructure.handler;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import user.manager.command.side.application.command.ProducerToSaveCommand;

@Component
public class PartyCommandHandler {	

	@Transactional
	public void handler(ProducerToSaveCommand command) {
		
	}

}
