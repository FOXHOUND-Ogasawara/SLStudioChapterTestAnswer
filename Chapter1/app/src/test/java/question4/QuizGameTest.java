package question4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuizGameTest {

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
    public void testQuizGame() throws Exception {
        String input = "Flour\nChina\nUnited Kingdom\nAmazon\nAlps\nCanberra\n";
        provideInput(input);
        QuizGame.main(new String[0]);
        String output = getOutput();

        Assertions.assertThat(output).contains("Your score is: 3");
        Assertions.assertThat(output).contains("Review the incorrect answers:");
        Assertions.assertThat(output).contains("Which country is known for inventing sushi?");
        Assertions.assertThat(output).contains("What is the longest river in the world?");
        Assertions.assertThat(output).contains("Mount Everest is located in which mountain range?");
    }
}
