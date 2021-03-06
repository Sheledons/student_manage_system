package cn.sheledon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 日志工具类
 * @author sheledon
 */
public class LoggerUtils {
    public static Logger getLogger(Class cs){
        return LoggerFactory.getLogger(cs);
    }
    public static String buildLogInfo(Object... objects){
        StringBuilder builder=new StringBuilder();
        for (Object o: objects){
            builder.append(o);
        }
        return builder.toString();
    }
}
