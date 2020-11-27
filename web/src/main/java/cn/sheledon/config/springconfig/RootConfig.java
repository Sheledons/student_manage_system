package cn.sheledon.config.springconfig;

import cn.sheledon.config.SpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sheledon
 */
@Configuration
@ComponentScan({"cn.sheledon"})
@Import({SpringConfig.class})
public class RootConfig {

}
