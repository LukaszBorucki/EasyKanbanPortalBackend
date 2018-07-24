package co.borucki.EasyKanbanPortalBackend.user.factory;

import co.borucki.EasyKanbanPortalBackend.user.dto.CreateUserDto;
import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import co.borucki.EasyKanbanPortalBackend.user.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserFactory {
    public UserModel fromDto(CreateUserDto userDto){
          return UserModel.builder()
                  .uuid(UUID.randomUUID().toString())
                  .name(userDto.getName())
                  .surname(userDto.getSurname())
                  .phone(userDto.getPhone())
                  .mail(userDto.getMail())
                  .password("temporaryPassword")
                  .role(UserRole.ADMIN)
                  .build();
    }
}
