package phitx.example.warehourse.services;

import org.springframework.stereotype.Service;
import phitx.example.warehourse.shared.DTO.UserTestDTO;

public interface UserTestService  {
    UserTestDTO createUserTest(UserTestDTO user);

}
