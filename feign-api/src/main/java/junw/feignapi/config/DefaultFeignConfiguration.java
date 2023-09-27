package junw.feignapi.config;


import feign.Logger;
import junw.feignapi.clients.fallback.UserClientFallbackFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author 64234
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    public UserClientFallbackFactory userClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }
}
