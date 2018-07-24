package co.borucki.EasyKanbanPortalBackend.user.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "easy_users")
public class UserModel {
    @Id
    @NotNull
    @Column(name = "id", unique = true)
    private String uuid;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "surname")
    private String surname;
    @NotNull
    @Column(name = "mail", unique = true)
    private String mail;
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Column(name = "role")
    private UserRole role;
    @NotNull
    @Column(name = "password")
    private String password;

    public UserModel() {
    }

    public UserModel(String uuid, String name, String surname, String mail, String phone, UserRole role, String password) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private String uuid;
        private String name;
        private String surname;
        private String mail;
        private String phone;
        private UserRole role;
        private String password;

        private Builder() {
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder role(UserRole role) {
            this.role = role;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserModel build() {
            return new UserModel(uuid, name, surname, mail, phone, role, password);
        }
    }

    public static UserModel.Builder builder() {
        return new UserModel.Builder();
    }
}
