package user.manager.command.side.infraestructure.converter;

public interface Converter<From, To> {
	
	To convert(From from);
	
}
