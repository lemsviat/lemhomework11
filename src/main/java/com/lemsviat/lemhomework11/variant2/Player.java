package main.java.com.lemsviat.lemhomework11.variant2;

public class Player {
    String name;
    UserTypes type;

    public Player() {
    }

    public Player(String name, UserTypes type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }
}
