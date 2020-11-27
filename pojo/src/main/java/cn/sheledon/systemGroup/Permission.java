package cn.sheledon.systemGroup;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author sheledon
 */

public enum Permission implements Serializable {
    STUDENT("student"),
    TEACHER("teacher"),
    MANAGER("manager");
    @Getter
    String name;
    Permission(String name) {
        this.name = name;
    }
}
