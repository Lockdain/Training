package com.lckdn.lambdas.com.lckdn.lambda.model;

public class RichPerson extends Person {
    private int salary;

    public RichPerson(String firstName, String lastName, int age, int salary) {
        super(firstName, lastName, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RichPerson{" +
                "First Name: " + super.getFirstName() + "; " +
                "Last Name: " + super.getLastName() + "; " +
                "Age: " + super.getAge() + "; " +
                "Salary: " + salary +
                '}';
    }
}
