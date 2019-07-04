package user.manager.command.side.infraestructure.persistence.mybatis.dao;

import user.manager.command.side.infraestructure.dto.PartyDto;

/**
 *
 *
 * @author daniel.carvajal
 */
public interface PartyDao extends Dao {

    Long nexValueForIdentifier();

    boolean saveParty(PartyDto partyDto);

    boolean savePerson(PartyDto partyDto);

    boolean saveGroup(PartyDto partyDto);
}
