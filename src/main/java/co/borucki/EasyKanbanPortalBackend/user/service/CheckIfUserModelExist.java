package co.borucki.EasyKanbanPortalBackend.user.service;

import co.borucki.EasyKanbanPortalBackend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckIfUserModelExist {
    private final UserRepository repository;

    public CheckIfUserModelExist(UserRepository repository) {
        this.repository = repository;
    }

    public boolean doesExist(String uuid) {
        return repository.existsById(uuid);
    }
}
