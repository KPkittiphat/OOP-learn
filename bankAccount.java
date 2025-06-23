public class bankAccount {
    private int id;
    private String name;
    private double salary;

    public bankAccount(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setSalary(double salary) {
        if (salary >= 100 && salary <= 1_000_000) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary must be between 15,000 and 1,000,000");
        }
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        bankAccount account = new bankAccount(675230, "Kittiphat Phengnamkham");
        account.setSalary(1000);
        System.out.println("Your ID : " + account.id);
        System.out.println("Your Namr Account : " + account.name);
        System.out.println(" Balance : " + account.getSalary() + " " + "Bath");
    }
}