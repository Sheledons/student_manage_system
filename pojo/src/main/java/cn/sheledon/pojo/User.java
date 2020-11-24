package cn.sheledon.pojo;

import cn.sheledon.systemGroup.Permission;
import lombok.*;


/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    /**
     * 后端检索出更改为枚举
     */
    private String strPermission;
//    private Permission permission;
}
