package ru.julia;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String name;
    private final BigDecimal salary;
    private final BigDecimal kpi;

    public Employee(String name, BigDecimal salary, BigDecimal kpi) {
        this.name = name;
        this.salary = salary;
        this.kpi = kpi;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal getKpi() {
        return kpi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
