package user.manager.store.service.infraestructure.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserDto {
    Long partyId;
    String socialIdentifier;
    String firstName;
    String lastName;
    String groupName;
    String userType;
    String description;
    String statusId;
    String comments;
}
