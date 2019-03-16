public class UserInfo {

    private String username;
    private String address;

    public UserInfo() {}

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() { return this.username; }
    public String getAddress() { return this.address; }
}
