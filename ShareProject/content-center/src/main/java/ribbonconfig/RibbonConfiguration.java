package ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mqxu
 */
//@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //command+option+b可以快速查看IRule的实现类
        return new RandomRule();
    }
}
