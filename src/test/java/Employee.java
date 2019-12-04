public class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public void mailCheck() {
        System.out.println("职工邮寄支票给： " + this.name
                + " " + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }

    public static void main(String [] args) {
        Salary s = new Salary("员工 A", "北京", 3, -3600.00);
        System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        s.mailCheck();

        Employee e = new Salary("员工 B", "上海", 2, 2400.00);
        System.out.println("\n使用 Employee 的引用调用 mailCheck--");
        e.mailCheck();//当子类对象调用重写的方法时，调用的是子类的方法，而不是父类中被重写的方法

    }




}
