package user.manager.command.side.infraestructure.converter;

import user.manager.command.side.domain.aggregate.model.user.UserIdentifier;
import user.manager.command.side.domain.aggregate.model.user.User;
import user.manager.command.side.domain.aggregate.model.user.UserTypeIdentifier;
import user.manager.command.side.infraestructure.dto.PartyDto;
import org.springframework.stereotype.Component;


@Component
public class FromUserConverter implements Converter<User, PartyDto>{

	public PartyDto convert(User user) {
		PartyDto partyDto = new PartyDto();
		partyDto.setPartyId(((UserIdentifier)user.getUserId()).getIdentifier());
		partyDto.setSocialIdentifier(user.getSocialIdentifier().getIdentifier());
		partyDto.setFirstName(user.getFirstName());
		partyDto.setLastName(user.getLastName());
		partyDto.setGroupName(user.getGroupName());
		partyDto.setPartyType(((UserTypeIdentifier) user.getUserType().getTypeId()).getIdentifier());
		// TODO:  add roles and geo

		return partyDto;
	}
}
