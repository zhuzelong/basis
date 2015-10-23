package controllers;

import play.*;
import play.mvc.*;
import play.Play;
import play.data.validation.*;

import models.*;

import org.json.*;

import java.util.*;


public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void showAddUser() {
        render();
    }

    public static void showSearchUser(String result) {
        render(result);
    }

    public static void addUser(
        @Required String id,
        @Required String name,
        @Required
        @Match(value="[0-9]{1,3}")
        int age,
        @Required boolean isNew
        ) {
        if (validation.hasErrors()) {
            render("Application/index.html");
        }

        int code = User.addUser(new User(id, name, age, isNew));
        // int code = User.addHUser(new User(id, name, age, isNew));
        if (code == 0) {
            flash.success("Successfully add a new user.");
        } else if (code == -1) {
            flash.error("The user id exists. Please check the user id.");
        } else {
            flash.error("Failed. Please check the fields.");
        }
        showAddUser();
    }

    public static void searchUser(@Required String queryText) {
        if (validation.hasErrors()) {
            render("Application/showSearchUser.html");
        }
        User users = User.findUser(queryText);
        if (users != null) {
            showSearchUser(users.toJson().toString(4));
        } else {
            showSearchUser("No user found. Please check the id.");
        }

        // showSearchUser(User.findHUser(queryText));
    }
}