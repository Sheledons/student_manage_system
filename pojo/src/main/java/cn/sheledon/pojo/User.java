package cn.sheledon.pojo;

import cn.sheledon.systemGroup.Permission;
import lombok.*;

import java.io.Serializable;


/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String userId;
    private String name;
    private String password;
    /**
     * 后端检索出更改为枚举
     */
    private String strPermission;
    private Permission permission;
}
