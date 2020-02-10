package phitx.example.warehourse.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import phitx.example.warehourse.entities.UserTest;
import phitx.example.warehourse.shared.DTO.UserTestDTO;

public interface UserTestService extends UserDetailsService {

    UserTestDTO createUserTest(UserTestDTO user);



}
