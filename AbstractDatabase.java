public interface AbstractDatabase {

    void setup(String filepath);
    void addUser(Integer userid, String username, String address) throws Exception;
    UserInfo getUserInfo(Integer userid);
}
