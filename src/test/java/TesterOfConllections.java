import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.util.*;

public class TesterOfConllections {
    @Test
    public void enumFunction( ) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }

    @Test
    public  void hashTable() {
            // Create a hash map
            Hashtable balance = new Hashtable();
            Enumeration names;
            String str;
            double bal;
        balance.put("Qadir", new Double(-19.08));
            balance.put("Zara", new Double(3434.34));
            balance.put("Mahnaz", new Double(123.22));
            balance.put("Ayan", new Double(1378.00));
            balance.put("Daisy", new Double(99.22));


            // Show all balances in hash table.
            names = balance.keys();
            while(names.hasMoreElements()) {
                str = (String) names.nextElement();
                System.out.println(str + ":----->  " + balance.get(str)
                        );
            }
            System.out.println();
            // Deposit 1,000 into Zara's account
            bal = ((Double)balance.get("Zara")).doubleValue();
            balance.put("Zara", new Double(bal+1000));
            System.out.println("Zara's new balance: " +
                    balance.get("Zara"));
        }

        @Test
    public  void property() {
        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        // Show all states and capitals in hashtable.
        states = capitals.keySet(); // get set-view of keys
        Iterator itr = states.iterator();
        while(itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of " +
                    str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        // look for state not in list -- specify default
        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is "
                + str + ".");
    }


    // 泛型,比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, @NotNull T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    @Test
    public   void CompareData(   )
    {
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }



}
