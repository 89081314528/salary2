package ru.julia;

import java.math.BigDecimal;

public class Salary {
    private final String name;
    private final BigDecimal salary;

    public Salary(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public Salary(String csv) {
        String[] salary = csv.split(";");
        this.name = salary[0];
        this.salary = new BigDecimal(salary[1]);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
