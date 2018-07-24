package co.borucki.EasyKanbanPortalBackend.user.repository;

import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>, JpaSpecificationExecutor<UserModel> {
    UserModel findByMail(String mail);

}
