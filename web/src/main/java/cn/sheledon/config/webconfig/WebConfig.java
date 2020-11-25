package cn.sheledon.config.webconfig;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheledon
 */
@Configuration
@ImportResource("classpath:springMVC-servlet.xml")
@EnableWebMvc
@ComponentScan("cn.sheledon.controller")
//@Import({SecurityConfig.class})
public class WebConfig  extends WebMvcConfigurationSupport {

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }
    /**
     * 配置fastJson转换器
     * @return
     */
    @Bean
    public FastJsonHttpMessageConverter getFastJsonConverter(){
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
        FastJsonConfig config=converter.getFastJsonConfig();
        Charset charset=Charset.forName("UTF-8");
        config.setCharset(charset);
        List<MediaType> list=new ArrayList<>();
        list.add(MediaType.ALL);
        converter.setSupportedMediaTypes(list);
        return converter;
    }
}
