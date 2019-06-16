package user.manager.command.side.infraestructure.persistence.mybatis.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.manager.command.side.infraestructure.dto.PartyDto;
import user.manager.command.side.infraestructure.persistence.mybatis.dao.PartyDao;
import user.manager.command.side.infraestructure.persistence.mybatis.mapper.PartyMapper;

/**
 *
 *
 * @author daniel.carvajal
 */
@Slf4j
@Component
public class PartyDaoImpl implements PartyDao {

    @Autowired
    private PartyMapper partyMapper;


    @Override
    public Long nexValueForIdentifier() {
        long partyId = 0;
        try {
            partyId = partyMapper.nexValueForIdentifier();
            if(partyId > 0){
                log.info("[{}] Se ha generado el nuevo [partyId : {}] correctamente!!!", PartyDaoImpl.class.getSimpleName(), partyId);
            }else{
                if(log.isWarnEnabled()){
                    log.warn("[{}] Ha ocurrido un error en la consistencia de la data, No se ha generado el [partyId] correctamente!!!", PartyDaoImpl.class.getSimpleName());
                }
            }
        }catch (Exception e){
            if(log.isErrorEnabled()) {
                log.error("[{}] Ha ocurrido un error al generar el [partyId] desde la base datos!!!", PartyDaoImpl.class.getSimpleName());
                log.error(e.getMessage(), e);
            }
        }
        return partyId;
    }

    @Override
    public boolean  saveParty(PartyDto partyDto) {
        int rowAffected;
        boolean isSaved = false;
        try {
            rowAffected = partyMapper.saveParty(partyDto);
            if(rowAffected == 1){
                isSaved = true;
                //
                log.info("[{}] Se ha insertado correctamente el participante[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
            }else{
                if(log.isWarnEnabled()){
                    log.warn("[{}] Ha ocurrido un error en la consistencia de la data al insertar el participante[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
                }
            }
        }catch (Exception e){
            if(log.isErrorEnabled()) {
                log.error("[{}] Ha ocurrido un error al insertar el participante[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
                log.error(e.getMessage(), e);
            }
        }
        return isSaved;
    }

    @Override
    public boolean savePerson(PartyDto partyDto) {
        int rowAffected;
        boolean isSaved = false;
        try {
            rowAffected = partyMapper.savePerson(partyDto);
            if(rowAffected == 1){
                isSaved = true;
                //
                log.info("[{}] Se ha insertado correctamente la persona[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
            }else{
                if(log.isWarnEnabled()){
                    log.warn("[{}] Ha ocurrido un error en la consistencia de la data al insertar la persona[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
                }
            }
        }catch (Exception e){
            if(log.isErrorEnabled()) {
                log.error("[{}] Ha ocurrido un error al insertar la persona[{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto);
                log.error(e.getMessage(), e);
            }
        }
        return isSaved;
    }

    @Override
    public boolean saveGroup(PartyDto partyDto) {
        int rowAffected;
        boolean isSaved = false;
        try {
            rowAffected = partyMapper.saveGroup(partyDto);
            if(rowAffected == 1){
                isSaved = true;
                //
                log.info("[{}] Se ha insertado correctamente el grupo[partyId :{}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto.getPartyId());
            }else{
                if(log.isWarnEnabled()){
                    log.warn("[{}] Ha ocurrido un error en la consistencia de la data al insertar el grupo[partyId : {}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto.getPartyId());
                }
            }
        }catch (Exception e){
            if(log.isErrorEnabled()) {
                log.error("[{}] Ha ocurrido un error al insertar el grupo[partyId : {}]!!!", PartyDaoImpl.class.getSimpleName(), partyDto.getPartyId());
                log.error(e.getMessage(), e);
            }
        }
        return isSaved;
    }
}
