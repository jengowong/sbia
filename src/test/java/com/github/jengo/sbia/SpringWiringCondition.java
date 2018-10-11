package com.github.jengo.sbia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * {@link SpringWiringCondition} Spring高级装配之条件化创建Bean
 *
 * https://www.jianshu.com/p/0761ba179625
 */
public class SpringWiringCondition {
}


class MagicBean {
}

class MagicExistsConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("magic");
    }
}

@Configuration
class ConditionalConfig {
    @Bean
    @Conditional(MagicExistsConditional.class) //条件化的创建bean
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
