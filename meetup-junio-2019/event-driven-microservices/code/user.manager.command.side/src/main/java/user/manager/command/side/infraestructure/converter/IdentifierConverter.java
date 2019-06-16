package user.manager.command.side.infraestructure.converter;

import user.manager.command.side.domain.aggregate.model.user.Identifier;
import org.springframework.stereotype.Component;

@Component
public class IdentifierConverter implements Converter<Long, Identifier>{

	public Identifier convert(Long id) {
		return new Identifier(String.valueOf(id));
	}	

}
