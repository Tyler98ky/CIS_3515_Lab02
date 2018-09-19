package edu.temple.startupform;

public class User {
    private String mName;
    private String mEmail;
    private String mPassword;

    public User(String name, String email, String password) {
        this.mName = name;
        this.mEmail = email;
        this.mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }
}
