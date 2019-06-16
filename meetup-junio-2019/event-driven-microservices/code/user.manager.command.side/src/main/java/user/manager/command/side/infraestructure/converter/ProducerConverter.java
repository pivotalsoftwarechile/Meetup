package user.manager.command.side.infraestructure.converter;

import user.manager.command.side.application.command.ProducerToSaveCommand;
import user.manager.command.side.domain.aggregate.model.user.NationalSingleRole;
import user.manager.command.side.domain.aggregate.model.user.User;
import user.manager.command.side.domain.aggregate.model.user.SocialIdentifier;

public class ProducerConverter implements Converter<ProducerToSaveCommand, User> {

	@Override
	public User convert(ProducerToSaveCommand command) {
		SocialIdentifier socialIdentifier = new NationalSingleRole(command.getNationalSingleRole());
		
		//Location city = new Location(locationId, locationType, locationCode, abbreviation);
		
		return null;
	}
	
	
	
	
}
