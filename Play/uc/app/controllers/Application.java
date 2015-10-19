package controllers;

import play.*;
import play.mvc.*;
import play.Play;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
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

        int code = User.addUser(id, name, age, isNew);
        if (code == 1) {
            flash.success("Successfully add a new user.");
        } else if (code == -1) {
            flash.error("The user id exists. Please check the user id.");
        } else {
            flash.error("Failed. Please check the fields.");
        }
        index();
    }
}