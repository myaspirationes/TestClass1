
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EvenNumberCheckerTest {
    private int inputNumber;
    private boolean isEven;

    // Step 3: parameterized constructor
    public EvenNumberCheckerTest(int inputNumber, boolean isEven) {
        super();
        this.inputNumber = inputNumber;
        this.isEven = isEven;
    }

    // Step 4: data set of variable values
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 2, true },
                { 5, false },
                { 10, true }
        };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        System.out.println("inputNumber: " + inputNumber + "; isEven: " + isEven);
        EvenNumberChecker evenNumberChecker = new EvenNumberChecker();
        // Step 5: use variables in test code
        boolean actualResult = evenNumberChecker.isEven(inputNumber);
        assertEquals(isEven, actualResult);
    }


}
