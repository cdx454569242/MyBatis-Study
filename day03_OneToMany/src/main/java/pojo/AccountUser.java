package pojo;

/**
 * @author
 * @create 2020-10-13 15:35
 */
public class AccountUser extends Account{
    private String username;
    private String address;

    @Override
    public String toString() {
        return super.toString() + "         AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
