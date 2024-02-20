package hw4;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDirectory {
    private List<Employee> employees;
    public EmployeesDirectory() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() { return employees; }

    
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        for (Employee employee : employees) {
            sBuilder.append(employee);
            sBuilder.append(", ");
        }
        
        if(employees.size() > 0)
            sBuilder.delete(sBuilder.length() - 2, sBuilder.length());
            
        sBuilder.append("]");
        return sBuilder.toString();
    }

    public void add(Employee employee){ 
        int index = indexOf(employee);
        if (index == -1)
            employees.add(employee);
        else
            employees.set(index, employee);
    }

    private int indexOf(Employee employee){
        for(int i = 0; i < employees.size(); i++)
        {
            if(employee.getTablelNumber().equals(employees.get(i).getTablelNumber()))
                return i;
        }
        return -1;
    }

    public List<Employee> findEmployeesByStage(int stage){
        List<Employee> result = employees.stream().filter(e -> e.getStage()==stage).toList();
        return result;
    }

    public List<String> findPhonesByName(String name){
        List<String> result = new ArrayList<>();
        employees.stream().filter(e -> e.getName().equals(name)).forEach(e -> result.add(e.getPhone()));
        return result;
    }

    public Employee findEmployeeByTableNumber(String tablleNum){
        for (Employee employee : employees) {
            if(employee.getTablelNumber().equals(tablleNum))
                return employee;
        }
        return null;
    }

}
