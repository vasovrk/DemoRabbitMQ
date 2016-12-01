package democammel;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "file")
public class EndpointProperties {

    private String producerUri;

    private String consumerUri;
}
