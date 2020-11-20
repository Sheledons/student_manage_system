package cn.sheledon.pojo;

import cn.sheledon.systemGroup.Permission;
import com.sun.deploy.association.Action;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Dictionary;

/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
@Builder
public class User {
    private String name;
    private Permission permission;

}
