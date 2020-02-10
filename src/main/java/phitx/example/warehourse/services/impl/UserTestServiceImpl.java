package phitx.example.warehourse.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import phitx.example.warehourse.entities.User;
import phitx.example.warehourse.entities.UserTest;
import phitx.example.warehourse.repository.UserTestRepository;
import phitx.example.warehourse.services.UserTestService;
import phitx.example.warehourse.shared.DTO.UserTestDTO;
import phitx.example.warehourse.shared.Util.Utils;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    UserTestRepository userTestRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserTestDTO createUserTest(UserTestDTO user) {

        UserTest storedUserEntity = userTestRepository.findUserByEmail(user.getEmail());
        if ( userTestRepository.findUserByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists!");

        UserTest userTest = new UserTest();
        BeanUtils.copyProperties(user, userTest);

        String publicUserId =  utils.generateUserId(30);
        userTest.setUserId(publicUserId);
        //userTest.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getUserId()));
        userTest.setEncryptedPassword("test");

        UserTest userTestEntity = userTestRepository.save(userTest);

        UserTestDTO returnValue = new UserTestDTO();
        BeanUtils.copyProperties(userTestEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
