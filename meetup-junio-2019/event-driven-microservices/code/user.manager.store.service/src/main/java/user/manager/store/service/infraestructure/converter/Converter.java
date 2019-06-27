package user.manager.store.service.infraestructure.converter;

public interface Converter<F, T> {

    public T convert(F from);

}
