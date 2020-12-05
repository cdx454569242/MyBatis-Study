package pojo;

import java.util.List;

/**
 * @author
 * @create 2020-10-12 19:21
 */
public class QueryVo {
    private User user;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
