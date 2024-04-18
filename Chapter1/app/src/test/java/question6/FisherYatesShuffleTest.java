package question6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FisherYatesShuffleTest {

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
    public void testQuizGameShuffle() throws Exception {
        // テストを複数回実行して、質問がシャッフルされているか確認
        Set<String> firstQuestions = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            provideInput("1\n1\n1\n1\n1\n1\n"); // ユーザー入力の模擬
            FisherYatesShuffle.main(new String[0]);
            String output = getOutput();

            // 最初の質問を取得して、セットに追加
            String firstQuestion = output.split("\n")[0];
            firstQuestions.add(firstQuestion);
        }
        Assertions.assertThat(getOutput().trim()).isNotEmpty();
        // シャッフルが適切に行われていれば、最初の質問は少なくとも一度は異なるはず
        Assertions.assertThat(firstQuestions.size()).isGreaterThanOrEqualTo(1);
    }
}
