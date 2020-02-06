package phitx.example.warehourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phitx.example.warehourse.entities.UserTest;

@Repository
public interface UserTestRepository extends CrudRepository<UserTest, Long> {
    UserTest findUserByEmail(String email);
}
