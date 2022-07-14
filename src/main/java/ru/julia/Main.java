package ru.julia;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Salary> salaries = getSalaries("salary.csv");
        List<Kpi> kpis = getKpis("kpi.csv");
        Map<String, SalaryAndKpi> salaryAndKpiMap = getSalaryAndKpiMap(salaries, kpis);
        List<Employee> employees = getEmployees(salaryAndKpiMap);
        getCsv(employees);

    }
    public static void getCsv(List<Employee> employees) throws FileNotFoundException {
        PrintStream csv = new PrintStream("employees.csv");
        csv.println("имя;зарплата;kpi");
        //!!!!!посмотреть компаратор
        Comparator comparator = new EmployeesByNameComparator();
        Collections.sort(employees, comparator);
        for (Employee employee : employees) {
           // строка плюс бигдецимал = строка?
            csv.println(employee.getName() + ";" +
                    employee.getSalary() + ";" +
                    employee.getKpi());
        }
    }
    public static List<Employee> getEmployees(Map<String, SalaryAndKpi> salaryAndKpiMap) {
        List<Employee> employees = new ArrayList<>();
        for (SalaryAndKpi salaryAndKpi : salaryAndKpiMap.values()) {
            Employee employee = new Employee(salaryAndKpi.getSalary().getName(),
                    salaryAndKpi.getSalary().getSalary(),
                    salaryAndKpi.getKpi().getKpi());
            employees.add(employee);
        }
        return employees;
    }
    public static Map<String, SalaryAndKpi> getSalaryAndKpiMap(List<Salary> salaries, List<Kpi> kpis ) {
        Map<String, SalaryAndKpi> map = new HashMap<>();
        for (Salary salary : salaries) {
            String name = salary.getName();
            SalaryAndKpi salaryAndKpi = new SalaryAndKpi(salary, null);
            map.put(name, salaryAndKpi);
        }
        return mapAddKpi(map, kpis);
    }
    public static Map<String, SalaryAndKpi> mapAddKpi(Map<String, SalaryAndKpi> map, List<Kpi> kpis) {
        for (Kpi kpi : kpis) {
            String name = kpi.getName();
            Salary salary = map.get(name).getSalary();
            SalaryAndKpi salaryAndKpi = new SalaryAndKpi(salary, kpi);
            map.put(name, salaryAndKpi);
        }
        return map;
    }

    public static List<Kpi> getKpis(String csvName) throws IOException {
        List<Kpi> kpis = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvName));
        reader.readLine();
        String line = reader.readLine();
        for (; line != null; line = reader.readLine()) {
            Kpi kpi = new Kpi(line);
            kpis.add(kpi);
        }
        return kpis;
    }

    public static List<Salary> getSalaries(String csvName) throws IOException {
        List<Salary> salaries = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvName));
        reader.readLine();
        String line = reader.readLine();
        for (; line != null; line = reader.readLine()) {
            Salary salary = new Salary(line);
            salaries.add(salary);
        }
        return salaries;
    }
}
