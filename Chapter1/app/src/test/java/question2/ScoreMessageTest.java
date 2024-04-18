package question2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreMessageTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testGreatScore() throws Exception {
        provideInput("85\n");
        ScoreMessage.main(new String[0]);
        Assertions.assertThat(getOutput().trim()).contains("Great!");
    }

    @Test
    public void testGoodScore() throws Exception {
        provideInput("65\n");
        ScoreMessage.main(new String[0]);
        Assertions.assertThat(getOutput().trim()).contains("Good!");
    }

    @Test
    public void testFairScore() throws Exception {
        provideInput("50\n");
        ScoreMessage.main(new String[0]);
        Assertions.assertThat(getOutput().trim()).contains("Fair.");
    }

    @Test
    public void testPoorScore() throws Exception {
        provideInput("30\n");
        ScoreMessage.main(new String[0]);
        Assertions.assertThat(getOutput().trim()).contains("Poor...");
    }

    @Test
    public void testInvalidScore() throws Exception {
        provideInput("-1\n");
        ScoreMessage.main(new String[0]);
        Assertions.assertThat(getOutput().trim()).contains("Invalid score.");
    }
}
