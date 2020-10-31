package cn.sheledon.config;

import cn.sheledon.config.springconfig.RootConfig;
import cn.sheledon.config.webconfig.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sheledon
 */
public class InitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 自动创建ContextClassLoaderListener 加载spring上下文的bean
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }
    /**
     * 加载web组件的bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
