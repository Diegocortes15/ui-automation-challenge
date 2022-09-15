package data;

public enum FakeUsers {

    FAKE_USER("nonexistinguser","nonexistingpassword");

    private final String username;
    private final String password;

    FakeUsers(String fakeUsername, String fakePassword) {
        this.username = fakeUsername;
        this.password = fakePassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
