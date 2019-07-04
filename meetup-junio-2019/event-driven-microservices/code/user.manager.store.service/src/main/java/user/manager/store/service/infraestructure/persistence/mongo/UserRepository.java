package user.manager.store.service.infraestructure.persistence.mongo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import user.manager.store.service.infraestructure.dto.UserDto;

@Repository
public interface UserRepository  extends ReactiveCrudRepository<UserDto, String> {
}
