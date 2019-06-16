package user.manager.command.side.infraestructure.persistence.mybatis.mapper;

import user.manager.command.side.infraestructure.dto.PartyDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartyMapper {

	Long nexValueForIdentifier();	
	
	int saveParty(PartyDto partyDto);
	
	int savePerson(PartyDto partyDto);
	
	int saveGroup(PartyDto partyDto);
	
}
