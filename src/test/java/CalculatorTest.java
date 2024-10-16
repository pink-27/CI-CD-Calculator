import org.example.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

class CalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // Test factorial operation with valid and invalid inputs
    @Test
    void testFactorialValidInput() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleFactorial(sc);
        assertTrue(outContent.toString().contains("120"));
    }

    @Test
    void testFactorialNegativeInput() {
        String input = "-5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleFactorial(sc);
        assertTrue(outContent.toString().contains("Error: Factorial of a negative number is not defined."));
    }

    @Test
    void testFactorialInvalidInput() {
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleFactorial(sc);
        assertTrue(outContent.toString().contains("Error: Please enter a valid integer for factorial calculation."));
    }

    // Test square root operation
    @Test
    void testSqrtValidInput() {
        String input = "16\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleSqrt(sc);
        assertTrue(outContent.toString().contains("4.0"));
    }

    @Test
    void testSqrtNegativeInput() {
        String input = "-4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleSqrt(sc);
        assertTrue(outContent.toString().contains("Error: Square root of a negative number is not allowed."));
    }

    @Test
    void testSqrtInvalidInput() {
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleSqrt(sc);
        assertTrue(outContent.toString().contains("Error: Please enter a valid number for square root calculation."));
    }

    // Test logarithm operation
    @Test
    void testLogValidInput() {
        String input = "10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleLog(sc);
        assertTrue(outContent.toString().contains("2.30"));
    }

    @Test
    void testLogNegativeInput() {
        String input = "-2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleLog(sc);
        assertTrue(outContent.toString().contains("Error: Logarithm of zero or negative number is not allowed."));
    }

    @Test
    void testLogInvalidInput() {
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handleLog(sc);
        assertTrue(outContent.toString().contains("Error: Please enter a valid number for logarithm calculation."));
    }

    // Test power operation
    @Test
    void testPowerValidInput() {
        String input = "2\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handlePower(sc);
        assertTrue(outContent.toString().contains("8.0"));
    }

    @Test
    void testPowerInvalidInput() {
        String input = "two\nthree\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        Main.handlePower(sc);
        assertTrue(outContent.toString().contains("Error: Please enter valid numbers for the power calculation."));
    }
}