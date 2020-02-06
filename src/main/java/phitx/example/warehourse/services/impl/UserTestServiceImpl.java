package phitx.example.warehourse.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phitx.example.warehourse.entities.User;
import phitx.example.warehourse.entities.UserTest;
import phitx.example.warehourse.repository.UserTestRepository;
import phitx.example.warehourse.services.UserTestService;
import phitx.example.warehourse.shared.DTO.UserTestDTO;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    UserTestRepository userTestRepository;

    @Override
    public UserTestDTO createUserTest(UserTestDTO user) {
        UserTest userTest = new UserTest();
        BeanUtils.copyProperties(user, userTest);

        userTest.setEncryptedPassword("test");

        UserTest userTestEntity = userTestRepository.save(userTest);

        UserTestDTO returnValue = new UserTestDTO();
        BeanUtils.copyProperties(userTestEntity, returnValue);

        return returnValue;
    }
}
