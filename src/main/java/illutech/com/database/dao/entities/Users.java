package illutech.com.database.dao.entities;

import jakarta.persistence.*;

@Entity(name = "users")
public class Users {

    public Users(){}
    public Users(String name){
        this.name = name;
    }
    public Users(int id, String name){
        this.name=name;
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
