package co.borucki.EasyKanbanPortalBackend.user.factory;

import co.borucki.EasyKanbanPortalBackend.user.dto.CreateUserDto;
import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import co.borucki.EasyKanbanPortalBackend.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserFactory {
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserModel fromDto(CreateUserDto userDto) {
        return UserModel.builder()
                .uuid(UUID.randomUUID().toString())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phone(userDto.getPhone())
                .mail(userDto.getMail())
                .password(passwordEncoder.encode(UUID.randomUUID().toString()))
                .role(UserRole.ADMIN)
                .build();
    }
}
