package democammel;

import java.io.InputStream;

public interface DemoCammelService {
    void processFile(InputStream file);

    /**
     * A demo method that sends the message to a camel uri
     * @param something The message to be sent
     */
    void tryToSendToRabbit(final String something);
}
