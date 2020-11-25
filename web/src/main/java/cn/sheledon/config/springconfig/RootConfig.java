package cn.sheledon.config.springconfig;

import cn.sheledon.config.DataBaseConfig;
import cn.sheledon.config.RedisConfig;
import cn.sheledon.config.SpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sheledon
 */
@Configuration
@ComponentScan({"cn.sheledon"})
@Import({SpringConfig.class, RedisConfig.class})
public class RootConfig {

}
