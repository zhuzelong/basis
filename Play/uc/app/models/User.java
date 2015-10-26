package models;

import play.db.jpa.*;
import play.data.validation.*;

import org.json.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.*;
import javax.persistence.*;


@Entity
public class User extends GenericModel {

    @Id
    @Required
    public String id;

    @Required
    public String name;

    @Required
    @Match("[0-9]{1,3}")
    public int age;

    @Required
    public boolean isNew;

    public static HConnection connection;

    public User(String id, String name, int age, boolean isNew) {
        this.id = id;
        this.name = name;
        this.age= age;
        this.isNew = isNew;
    }

    public static int addUser(User user) {
        /**
          * Return operation code:
          * success(1), failed(0), existed user(-1)
        */
        boolean existed = User.count("byId", user.id) > 0;
        if (existed) {
            return -1;
        } else {
            user.save();
            return 0;
        }
    }

    public static int addHUser(User user) throws IOException {
        HTableInterface table = connection.getTable("users");
        Put put = new Put(Bytes.toBytes(user.id));
        put.add(Bytes.toBytes("info"),
                Bytes.toBytes("id"),
                Bytes.toBytes(user.id)
                );
        table.put(put);
        return 0;
    }

    public static User findUser(String id) {
        return User.find("byId", id).first();
    }

    public static JSONObject findHUser(String id) throws IOException {
        HTableInterface table = connection.getTable("users");
        Get get = new Get(Bytes.toBytes(id));
        get.addFamily(Bytes.toBytes("info"));
        Result rslt = table.get(get);
        Map<byte[], byte[]> userMap = rslt.getFamilyMap(Bytes.toBytes("info"));

        String source = "{";
        for (Map.Entry<byte[], byte[]> entry: userMap.entrySet()) {
            source += String(entry.getKey()) + ":" + String(entry.getValue());
        }
        source += "}";
        return new JSONObject(source);
    }

    public JSONObject toJson() {
        // The keys must be identical to the fields (case sensitive)
        String[] keys = {"id", "name", "age", "isNew"};
        return new JSONObject(this, keys);
    }

    public String toString() {
        System.out.println("Testing: output an object.");
        return "id=" + this.id + "\nname=" + this.name + "\nage=" + this.age;
    }

}