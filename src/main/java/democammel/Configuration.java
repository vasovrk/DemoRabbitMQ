package democammel;


import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public DemoCammelService demoCammelService(EndpointProperties endpointProperties,
                                               ProducerTemplate fileNotifierTemplate){
        return new DemoCammelServiceImpl(endpointProperties, fileNotifierTemplate);
    }

}
