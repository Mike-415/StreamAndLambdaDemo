package LambdaExpAndStreams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class Streams
{
    static int[] randomNumGenerator(int[] intArr)
    {
        for(int i= 0; i < intArr.length; i++)
        {
            Random random = new Random();
            int randomNum = random.nextInt(300)+75;
            intArr[i] = randomNum;
        }
        return intArr;
    }

    static void average(int[] intArr)
    {
        System.out.print("\n\nThe array's average:   ");
        Arrays.stream(intArr)
                .average()
                .ifPresent(a -> System.out.printf("%.2f", a));
    }



    static void evenNumbers(int[] intArr)
    {
        IntStream evenNums = Arrays.stream(intArr)
                .filter(n -> n%2 == 0);
        System.out.println("\n\nThe number of even elements:   "+evenNums.count());
        System.out.print("\nThe average of all even numbers:   ");
        Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .average()
                .ifPresent(b -> System.out.printf("%.2f", b));
    }

    static void greaterThanOddAvg(int[] intArr)
    {
        System.out.println("\n\nNumbers greater than the average of all odd numbers:   ");
        OptionalDouble oddAvg = Arrays.stream(intArr)
                .filter(a -> a%2 == 1)
                .average();
        Arrays.stream(intArr)
                .filter(a -> a > Math.floor(oddAvg.getAsDouble()))
                .forEach(b -> System.out.print(b+" "));
    }

    static void greaterThan100andDivisibleBy5(int[] intArr)
    {
        System.out.println("\n\nNumbers greater than 1000 and divisible by 5: ");
        Arrays.stream(intArr)
                .filter(a -> ( a > 100 ) && ( a%5 == 0 ) )
                .sorted()
                .forEach(b -> System.out.print(b+" "));
    }


    public static void main(String...args)
    {
        int intArr[] =new int[100];
        intArr = randomNumGenerator(intArr);
        average(intArr);
        evenNumbers(intArr);
        greaterThanOddAvg(intArr);
        greaterThan100andDivisibleBy5(intArr);
    }

}
