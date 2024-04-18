package question8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenreQuizTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
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
    public void testValidGenreAndCorrectAnswer() throws Exception {
        String input = "Food\n3\n3\n3\n";
        provideInput(input);
        GenreQuiz.main(new String[0]);
        String output = getOutput();
        Assertions.assertThat(output).contains("Select a genre: Food, Geography");
        Assertions.assertThat(output).contains("Correct!");
    }

    @Test
    public void testInvalidGenre() throws Exception {
        String input = "Science\nFood\n3\n3\n3\n";
        provideInput(input);
        GenreQuiz.main(new String[0]);
        String output = getOutput();
        Assertions.assertThat(output).contains("Invalid genre. Please try again.");
        Assertions.assertThat(output).contains("Correct!");
    }

}
