package cn.sheledon.impl;

/**
 * @author sheledon
 */
public interface BaseEnum<C> {
    /**
     * 能唯一确定一个枚举的字段
     * @return
     */
    C getName();
}
