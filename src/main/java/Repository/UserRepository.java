package Repository;
import jakarta.transaction.Transactional;
import org.apache.catalina.UserDatabase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import Model.Record.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel save(UserModel user);
    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.id = :newId WHERE u.id = :oldId")
    void updateUserId(Long oldId, UserDatabase newId);

}