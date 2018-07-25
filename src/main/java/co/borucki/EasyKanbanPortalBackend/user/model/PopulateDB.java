package co.borucki.EasyKanbanPortalBackend.user.model;

import co.borucki.EasyKanbanPortalBackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PopulateDB {
    private final UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public PopulateDB(UserRepository repository) {
        this.repository = repository;
    }

    @Bean
    public CommandLineRunner initDatabase() {

        UserModel userModel = UserModel.builder()
                .mail("lukasz.borucki@sienn.pl")
                .name("Łukasz")
                .surname("Borucki")
                .uuid(UUID.randomUUID().toString())
                .role(UserRole.SUPERADMIN)
                .phone("+48 502 387 119")
                .password(passwordEncoder.encode("zaq1@WSX"))
                .build();


        return args -> {
            if (this.repository.findAll().size() == 0) {
                this.repository.save(userModel);
            }
        };
    }

}
