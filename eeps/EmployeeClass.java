package eeps;

abstract class EmployeeClass {

    protected String name ;
    protected int id ;
    protected int age ;
    protected double salary ;

    EmployeeClass() {};

    EmployeeClass (String name , int id , int age ){
        this.id = id ;
        this.age = age ;
        this.name=name ;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    

    // Add here any methods for the Employee ...


}
