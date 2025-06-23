class Calculate {

    public double calculateAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            return -1;
        }
        return (double) a / b;
    }
}

public class CalculateAverage {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Calculate cal = new Calculate();

        double average = cal.calculateAverage(arr);
        System.out.println("Average: " + average);

        //  method 
        System.out.println("Add 5 + 3 = " + cal.add(5, 3));
        System.out.println("Subtract 5 - 3 = " + cal.subtract(5, 3));
        System.out.println("Multiply 5 * 3 = " + cal.multiply(5, 3));
        System.out.println("Divide 5 / 3 = " + cal.divide(5, 3));
        System.out.println("Divide 5 / 0 = " + cal.divide(5, 0)); // ทดสอบกรณี b = 0
    }
}
