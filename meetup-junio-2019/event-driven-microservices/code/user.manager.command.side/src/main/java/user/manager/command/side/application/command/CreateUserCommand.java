package user.manager.command.side.application.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserCommand {
	public String nationalSingleRole;
	public String firstName;
	public String lastName;
	public String cityId;
	public String comuneId;
	public String regionId;
	public String country;
	public String siteOfProduction;
	public String globalGapNumber;
	
}
