package user.manager.command.side.application.command;

import lombok.Value;

@Value
public class UpdateGroupCommand {
	public String tributarySingleRole;
	public String groupName;
	public String cityId;
	public String comuneId;
	public String regionId;
	public String country;
}
