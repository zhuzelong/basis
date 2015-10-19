package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends GenericModel {

    @Id
    @Required
    public String id;

    @Required
    public String name;

    @Required
    @Match("[0-9]{3}")
    public int age;

    @Required
    public boolean isNew;

    public User(String id, String name, int age, boolean isNew) {
        this.id = id;
        this.name = name;
        this.age= age;
        this.isNew = isNew;
    }

    public static int addUser(String id, String name, int age, boolean isNew) {
        /**
          * Return operation code:
          * success(1), failed(0), existed user(-1)
        */
        boolean existed = User.count("byId", id) > 0;
        if (existed) {
            return -1;
        }

        User user = new User(id, name, age, isNew).save();
        return 1;
    }

}