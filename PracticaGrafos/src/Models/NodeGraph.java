package Models;
import java.util.LinkedList;
import java.util.List;

public class NodeGraph<T> {
    private T user;
    private List<T> friends;

    public NodeGraph(T value) {
        this.user = value;
        this.friends= new LinkedList<>();
    }

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public List<T> getFriends() {
        return friends;
    }

    public void setFriends(T friend) {
        this.user = friend;
    }
    

    public void addFriend(T friend) {
        friends.add(friend);
    }
    
}

