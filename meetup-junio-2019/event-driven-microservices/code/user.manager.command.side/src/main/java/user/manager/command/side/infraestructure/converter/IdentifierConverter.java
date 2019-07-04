package user.manager.command.side.infraestructure.converter;

import user.manager.command.side.domain.aggregate.model.user.Identifier;
import org.springframework.stereotype.Component;
import user.manager.command.side.domain.aggregate.model.user.UserIdentifier;

import java.util.Optional;

@Component
public class IdentifierConverter implements Converter<Long, Optional<Identifier>>{

	public Optional<Identifier> convert(Long id) {
		return Optional.of(new UserIdentifier(id));
	}	

}
