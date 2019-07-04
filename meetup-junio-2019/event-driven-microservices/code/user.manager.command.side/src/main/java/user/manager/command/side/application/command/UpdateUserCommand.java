package user.manager.command.side.application.command;

import lombok.Value;

@Value
public class UpdateUserCommand {
	public String nationalSingleRole;
	public String firstName;
	public String lastName;
	public String cityId;
	public String comuneId;
	public String regionId;
	public String country;
}
