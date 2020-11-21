package cn.sheledon.pojo;

import cn.sheledon.systemGroup.Permission;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
@Builder
public class User {
    private String name;
    /**
     * 后端检索出更改为枚举
     */
    private String strPermission;
    private Permission permission;
}
