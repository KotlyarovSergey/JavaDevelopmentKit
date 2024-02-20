package hw4;

public class Main {
    public static void main(String[] args) {
        EmployeesDirectory emplDir = createDirectory();
        System.out.println(emplDir);
        

        System.out.println(emplDir.findEmployeesByStage(4));
        System.out.println(emplDir.findEmployeesByStage(44));


        System.out.println(emplDir.findPhonesByName("Ольга"));
        System.out.println(emplDir.findPhonesByName("Евгений"));


        System.out.println(emplDir.findEmployeeByTableNumber("2345413"));
        System.out.println(emplDir.findEmployeeByTableNumber("153135"));
    }


    public static EmployeesDirectory createDirectory(){
        EmployeesDirectory dir = new EmployeesDirectory();

        Employee employee = new Employee("2345413", "Иван", "92421345678", 5);
        dir.add(employee);

        employee = new Employee("353135", "Владимир", "9251345678", 4);
        dir.add(employee);

        employee = new Employee("46568", "Ольга", "9285436547", 6);
        dir.add(employee);
        employee = new Employee("24657834", "Александр", "9183456483", 4);
        dir.add(employee);
        employee = new Employee("153135", "Ирина", "9092134568", 3);
        dir.add(employee);
        employee = new Employee("6843519", "Евгений", "9083216849", 1);
        dir.add(employee);
        employee = new Employee("95432", "Евгений", "9065684547", 6);
        dir.add(employee);
        

        return dir;
    }





}
