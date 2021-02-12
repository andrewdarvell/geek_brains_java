public class Person {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.printf("Сотрудник: %s%n", fio);
        System.out.printf("Должность: %s%n", position);
        System.out.printf("Email: %s%n", email);
        System.out.printf("Номер телефона: %s%n", phone);
        System.out.printf("Зарплата: %d%n", salary);
        System.out.printf("Возраст: %s%n", age);
        System.out.println();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
