import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

import org.junit.*;

public class calculatorTest  {

    Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @After
    public void tearDown() {
        this.calculator = null;
    }

    @Test
    @Ignore
    public void testAdd() {
        Assert.assertEquals(100, this.calculator.add(100));
        Assert.assertEquals(150, this.calculator.add(50));
        Assert.assertEquals(130, this.calculator.add(-20));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(-100, this.calculator.sub(100));
        Assert.assertEquals(-150, this.calculator.sub(50));
        Assert.assertEquals(-130, this.calculator.sub(-20));
    }



    @Test
    public void getRandomIndexData(){
        Scanner in = new Scanner(System.in);
        System.out.println("需要抽取的个数：");
        int k = in.nextInt();
        System.out.println("总共存在的个数：");
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            numbers.add(i + 1);
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i ++){
            int r = generateRandomIndex(n - i);
            result[i] = numbers.get(r);
            numbers.remove(r);
        }
        //System.out.println(result);
        Arrays.sort(result);
        System.out.println("Lucky numbers: ");
        for(int i : result) {
            System.out.println(i);
        }
    }
    private static int generateRandomIndex(int n){
        Random random = new Random();
        //return an int that between 0 and n, 0 included, n not included
        return random.nextInt(n);
    }
}
