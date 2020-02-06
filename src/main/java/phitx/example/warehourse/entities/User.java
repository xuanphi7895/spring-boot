package phitx.example.warehourse.entities;


import phitx.example.warehourse.entities.AbstractClass.GenericClass;

import javax.persistence.Column;

public class User extends GenericClass {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
