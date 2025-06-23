public class LoopWithArrayExample {
    public static void main(String[] args) {
        int[] numbers = { 111, 222, 333, 444, 555 };
        // Code ต่อ
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("ผลรวมของอาเรย์คือ: " + sum);
    }
}