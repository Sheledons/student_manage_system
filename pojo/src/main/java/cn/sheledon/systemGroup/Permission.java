package cn.sheledon.systemGroup;

import java.io.Serializable;

/**
 * @author sheledon
 */

public enum Permission implements Serializable {
    STUDENT("student"),
    TEACHER("teacher"),
    MANAGER("manager");
    String name;
    Permission(String name) {
        this.name = name;
    }
}
