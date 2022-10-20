package data;

public enum Users {

    FAKE_USER("nonexistinguser","nonexistingpassword"),
    USER(System.getenv("MOVIEDB_USERNAME"),System.getenv("MOVIEDB_PASSWORD"));

    private final String username;
    private final String password;

    Users(String fakeUsername, String fakePassword) {
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
