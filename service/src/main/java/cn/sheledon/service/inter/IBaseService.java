package cn.sheledon.service.inter;

/**
 * @author sheledon
 */
public interface IBaseService {
    /**
     * 根据User获得相应的角色
     * @param userId
     * @return
     */
    Object getRoleByUserId(String userId);
}
