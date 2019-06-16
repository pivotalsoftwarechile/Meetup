package user.manager.command.side.infraestructure.persistence.mybatis.mapper;

import user.manager.command.side.infraestructure.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {	
	
	void addPartyRole(RoleDto roleDto);
	
	
	
}
