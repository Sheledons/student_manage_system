package cn.sheledon.utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;
/**
 * @author sheledon
 */
public class SessionUtils {

    public static Object getObjectFromSession(HttpServletRequest request,String key){
        if (request==null || key==null){
            throw new NullPointerException();
        }
        HttpSession session=request.getSession();
        Object o=session.getAttribute(key);
        return Objects.requireNonNull(o);
    }



    public static void setAttributeToSession(HttpServletRequest request,String key,Object value){
        HttpSession session=request.getSession();
        session.setAttribute(key,value);
    }
}
