package user.manager.command.side.infraestructure.dto;

import lombok.Data;

import java.util.Date;


@Data
public class PartyDto {
	Long partyId;	
	String socialIdentifier;
	String firstName;
	String lastName;
	String groupName;	
	String partyType;
	String description;
	String statusId;
	String comments;
	
	Date createdDate;
	String createByUserLogin;
	Date lastModifiedDate;
	String lastModifiedByUserLogin;
}
