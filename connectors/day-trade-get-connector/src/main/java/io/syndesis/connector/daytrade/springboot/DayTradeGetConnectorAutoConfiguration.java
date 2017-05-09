package io.syndesis.connector.daytrade.springboot;

import java.util.HashMap;
import java.util.Map;
import io.syndesis.connector.daytrade.DayTradeGetComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.util.IntrospectionSupport;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Generated by camel-connector-maven-plugin - do not edit this file!
 */
@Configuration
@ConditionalOnBean(type = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@AutoConfigureAfter(name = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@EnableConfigurationProperties(DayTradeGetConnectorConfiguration.class)
public class DayTradeGetConnectorAutoConfiguration {

    @Lazy
    @Bean(name = "day-trade-get-component")
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean(io.syndesis.connector.daytrade.DayTradeGetComponent.class)
    public DayTradeGetComponent configureDayTradeGetComponent(
            CamelContext camelContext,
            DayTradeGetConnectorConfiguration configuration) throws Exception {
        DayTradeGetComponent connector = new DayTradeGetComponent();
        connector.setCamelContext(camelContext);
        Map<String, Object> parameters = new HashMap<>();
        IntrospectionSupport.getProperties(configuration, parameters, null,
                false);
        IntrospectionSupport.setProperties(camelContext,
                camelContext.getTypeConverter(), connector, parameters);
        connector.setComponentOptions(parameters);
        return connector;
    }
}