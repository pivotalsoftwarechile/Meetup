package user.manager.command.side.infraestructure.converter;

import user.manager.command.side.domain.aggregate.model.user.User;
import user.manager.command.side.infraestructure.dto.PartyDto;
import org.springframework.stereotype.Component;


@Component
public class PartyConverter implements Converter<User, PartyDto>{

	public PartyDto convert(User producer) {
		PartyDto partyDto = new PartyDto();
		partyDto.setPartyId(Long.valueOf(producer.getProducerId().getId()));
		partyDto.setSocialIdentifier(producer.getSocialIdentifier().getIdentifier());
		partyDto.setFirstName(producer.getFirstName());
		partyDto.setLastName(producer.getLastName());	
		
		return partyDto;
	}

	

}
