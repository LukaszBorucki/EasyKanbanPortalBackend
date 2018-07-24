package co.borucki.EasyKanbanPortalBackend;

import co.borucki.EasyKanbanPortalBackend.user.dto.UserDto;
import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class OrikaMapper extends ConfigurableMapper {
    @Override
    protected void configureFactoryBuilder(DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.build();
    }

    @Override
    protected final void configure(final MapperFactory factory) {
        factory
                .classMap(UserModel.class, UserDto.class)
                .field("uuid", "id")
                .byDefault()
                .register();
    }
}
