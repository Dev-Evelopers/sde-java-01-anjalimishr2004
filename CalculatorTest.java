import java.util.Scanner;

abstract class Calculator {
    abstract int add(int a, int b);
}

class Adder extends Calculator {
    int add(int a, int b) {
        System.out.println("Adding integers: " + a + " " + b);
        return a + b;
    }
}

class Multiplier {
    int multiply(int a, int b, Calculator calculator) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return result;
    }
}

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Adder adder = new Adder();
        System.out.println("Testing Addition");
        int sum = adder.add(a, b);
        System.out.println("Sum = " + sum);

        Multiplier multiplier = new Multiplier();
        System.out.println("Testing Multiplication");
        int product = multiplier.multiply(a, b, adder);
        System.out.println("Product = " + product);
    }
}
