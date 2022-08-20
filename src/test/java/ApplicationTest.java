import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * Application Tester.
 *
 * @author Guillermo
 * @version 1.0
 * @since <pre>ago. 20, 2022</pre>
 */
class ApplicationTest {
    private Application application;
    private static final String TEST_INPUT_1 = "1\nN\n";
    private static final String TEST_INPUT_2 = "0\n2\nN\n";
    private static final String TEST_INPUT_3 = "3\nInvalid\nN\n";

    private void initialize(ByteArrayInputStream input) {
        application = new Application(input);
    }

    @Test
    void testShouldProcessOk() {
        initialize(new ByteArrayInputStream(TEST_INPUT_1.getBytes()));
        Assertions.assertDoesNotThrow(() -> application.run());
    }

    @Test
    void testShouldProcessInvalidFirstNumberOk() {
        initialize(new ByteArrayInputStream(TEST_INPUT_2.getBytes()));
        Assertions.assertDoesNotThrow(() -> application.run());
    }

    @Test
    void testShouldProcessInvalidEndCharOk() {
        initialize(new ByteArrayInputStream(TEST_INPUT_3.getBytes()));
        Assertions.assertDoesNotThrow(() -> application.run());
    }
} 
