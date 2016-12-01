package democammel;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.InputStream;

@EnableConfigurationProperties(EndpointProperties.class)
public class DemoCammelServiceImpl implements DemoCammelService {

    private final EndpointProperties endpointProperties;

    private final ProducerTemplate fileNotifierTemplate;

    public DemoCammelServiceImpl(EndpointProperties endpointProperties, ProducerTemplate fileNotifierTemplate) {
        this.endpointProperties = endpointProperties;
        this.fileNotifierTemplate = fileNotifierTemplate;
    }

    public void processFile(final InputStream file) {
        fileNotifierTemplate.asyncSend(endpointProperties.getConsumerUri(), ex -> ex.getIn().setBody(file));
    }
}
