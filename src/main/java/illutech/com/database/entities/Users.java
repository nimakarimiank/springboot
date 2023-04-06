package illutech.com.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "users")
public class Users {

    @Id
    @Column(name = "user_id")

    private int id;

}
