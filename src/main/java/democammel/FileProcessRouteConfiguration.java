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


//    @Bean
//    public RouteBuilder fileProcessRouteBuilder(){
//        return new RouteBuilder() {
//            @Override
//            public void configure() throws Exception {
//                from(endpointProperties.getProducerUri())
//                .split(body().tokenize("\n"))
//                        .parallelProcessing()
//                        .choice()
//                        .when(body().contains("vasilikin"))
//                        .process(ex -> {System.out.println(ex.getIn().getBody());
//                            System.out.println(endpointProperties.getRabbitUri());})
//                        .end()
//                        .to(endpointProperties.getConsumerUri());
//
//            }
//        };
//    }



    @Bean
    public RouteBuilder fromRabbitToFile(){
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
              from(endpointProperties.getRabbitUri())
                      .process(ex -> System.out.println(ex.getIn().getBody()))
                      .to(endpointProperties.getConsumerUri());
            }
        }    ;
    }

    @Bean
    public RouteBuilder fromCamelQueueToRabbit(){
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(endpointProperties.getTestCamelUri())
                        .process(ex -> {System.out.println(ex.getIn().getBody());
                            System.out.println(endpointProperties.getRabbitUri());})
                        .to(endpointProperties.getRabbitUri());

            }
        };
    }




}
