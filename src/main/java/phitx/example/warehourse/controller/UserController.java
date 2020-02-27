package phitx.example.warehourse.controller;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import phitx.example.warehourse.entities.UserTest;
import phitx.example.warehourse.model.request.UserDetailRequestModel;
import phitx.example.warehourse.model.response.UserTestRest;
import phitx.example.warehourse.services.UserTestService;
import phitx.example.warehourse.shared.DTO.UserTestDTO;
import phitx.example.warehourse.shared.Util.Utils;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserTestService userService;



    @GetMapping(path="/{userId}",
                produces ={ MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE})
    public UserTestRest getUser(@PathVariable String userId)
    {
        UserTestRest returnValue = new UserTestRest();

        UserTestDTO returnUser = userService.getUserById(userId);

        BeanUtils.copyProperties(returnUser, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserTestRest createUser(@RequestBody UserDetailRequestModel userDetails){

        UserTestRest returnValue = new UserTestRest();

        UserTestDTO userDTO = new UserTestDTO();
        userDTO.setEncryptedPassword(userDetails.getPassword());
        BeanUtils.copyProperties(userDetails, userDTO);

        UserTestDTO createUser = userService.createUserTest(userDTO);
        BeanUtils.copyProperties(createUser, returnValue);

        return returnValue;
    }

}
