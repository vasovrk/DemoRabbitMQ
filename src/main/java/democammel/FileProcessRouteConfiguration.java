package democammel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(EndpointProperties.class)
public class FileProcessRouteConfiguration {


    @Autowired
    private EndpointProperties endpointProperties;

    @Bean
    public RouteBuilder fileProcessRouteBuilder(){
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(endpointProperties.getConsumerUri())
                .split(body().tokenize("\n"))
                        .parallelProcessing()
                        .choice()
                        .when(body().contains("vasilikin"))
                        .process(ex -> System.out.println(ex.getIn().getBody()))
                        .end()
                        .to(endpointProperties.getProducerUri());

            }
        };
    }
}
