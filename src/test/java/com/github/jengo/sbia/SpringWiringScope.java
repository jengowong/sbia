package com.github.jengo.sbia;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * {@link SpringWiringScope} Spring高级装配之Bean的作用域
 *
 * https://www.jianshu.com/p/fcdcbaace675
 */
public class SpringWiringScope {
}

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class NotePad {
}

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
class Cart {
}