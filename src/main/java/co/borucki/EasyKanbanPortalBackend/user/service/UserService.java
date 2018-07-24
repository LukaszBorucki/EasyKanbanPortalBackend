package co.borucki.EasyKanbanPortalBackend.user.service;

import co.borucki.EasyKanbanPortalBackend.user.exception.UserAlreadyExist;
import co.borucki.EasyKanbanPortalBackend.user.exception.UserDoesNotExist;
import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import co.borucki.EasyKanbanPortalBackend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
private final CheckIfUserModelExist userModelExist;
    public UserService(UserRepository repository, CheckIfUserModelExist userModelExist) {
        this.repository = repository;
        this.userModelExist = userModelExist;
    }

    public UserModel create(UserModel userModel) {
        if (repository.findByMail(userModel.getMail()) != null) {
            throw new UserAlreadyExist("User with mail: " + userModel.getMail() + " already exist");
        }
        return repository.save(userModel);
    }

    public List<UserModel> getAll() {
        return repository.findAll();
    }

    public Optional<UserModel> getById(String id) {
        if(userModelExist.doesExist(id)){
            return repository.findById(id);
        }
        else throw new UserDoesNotExist("User : " + id + " does not exist");
            }

    public UserModel getByMail(String mail) {
        UserModel userModel;
        if ((userModel = repository.findByMail(mail)) != null) {
            return userModel;
        } else {
            throw new UserDoesNotExist("User with mail: " + mail + " does not exist");
        }
    }
}
