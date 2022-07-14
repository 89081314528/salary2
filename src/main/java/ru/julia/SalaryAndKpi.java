package ru.julia;

public class SalaryAndKpi {
    Salary salary;
    Kpi kpi;

    public SalaryAndKpi(Salary salary, Kpi kpi) {
        this.salary = salary;
        this.kpi = kpi;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Kpi getKpi() {
        return kpi;
    }

    public void setKpi(Kpi kpi) {
        this.kpi = kpi;
    }
}
