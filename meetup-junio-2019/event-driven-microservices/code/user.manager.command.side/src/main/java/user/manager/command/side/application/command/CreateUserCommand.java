package user.manager.command.side.application.command;

import lombok.Value;

@Value
public class CreateUserCommand {
	public String nationalSingleRole;
	public String firstName;
	public String lastName;

	// todo add 1 ...n fields
}
