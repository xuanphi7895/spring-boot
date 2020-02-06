package phitx.example.warehourse.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name ="user_test")

public class UserTest implements Serializable {

        private static final long serialVersionUID = 5436434563546536L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;

        @Column(nullable = false)
        private String userId;

        @Column(nullable = false, length=50)
        private String firstName;

        @Column(nullable = false, length=50)
        private String lastName;

        @Column(nullable = false, length=120)
        private String email;

        @Column(nullable = false)
        private String encryptedPassword;

        private String emailVerificationToken;

        @Column(nullable = false)
        private Boolean emailVerificationStatus = false;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
