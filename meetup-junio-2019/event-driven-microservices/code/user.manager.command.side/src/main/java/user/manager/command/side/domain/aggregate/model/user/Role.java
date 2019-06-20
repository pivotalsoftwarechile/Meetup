package user.manager.command.side.domain.aggregate.model.user;

import lombok.Value;

@Value
public class Role {
	
    private final UserTypeIdentifier roleId;
    private final Type roleType;
    private final String roleDescription;
    
    public Role(UserTypeIdentifier roleId, Type roleType, String roleDescription) {
    	this.roleId = roleId;
    	this.roleType = roleType;
    	this.roleDescription = roleDescription;
    }  
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {    	
    	return new Role(roleId, roleType, roleDescription);
    }
}
    
