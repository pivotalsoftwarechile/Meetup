package user.manager.command.side.domain.aggregate.model.user;

import java.util.Optional;

public interface UserRepository {

    Optional<Identifier> getUserId();

    Optional<User> addUser(User user);

    Optional<User> editUser(User user);

    Optional<User> removeUser(User user);

}