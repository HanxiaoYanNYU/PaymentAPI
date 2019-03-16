import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase implements AbstractDatabase {

  private static final Map<Integer, UserInfo> ID_TO_USERINFO = new HashMap<>();

  @Override
  public void setup(String filepath) { readDB(filepath); }

  public void readDB(String filepath) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(UserDatabase.class.getClassLoader().getResourceAsStream(filepath)))) {
      String line;
        while ((line = br.readLine()) != null) {
          String splits[] = line.split("\t");
          Integer userid = Integer.parseInt(splits[0]);
          String username = splits[1];
          String address = splits[2];
          addUser(userid, username, address);
        }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addUser(Integer userid, String username, String address) throws Exception {
    if (ID_TO_USERINFO.containsKey(userid)) {
      throw new Exception("Input userid already exist.");
    }
    else {
        ID_TO_USERINFO.put(userid, new UserInfo(username, address));
    }
  }

  @Override
  public UserInfo getUserInfo(Integer userid) {
    UserInfo userInfo = null;
    try {
      if (!ID_TO_USERINFO.containsKey(userid)) throw new Exception("UserId not exist.");
      userInfo = ID_TO_USERINFO.get(userid);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return userInfo;
    }
  }
}