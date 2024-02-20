package hw4;

public class Employee {
    private String tablelNumber;
    private String name;
    private String phone;
    private int stage;
    public Employee(String tablelNumber, String name, String phone, int stage) {
        this.tablelNumber = tablelNumber;
        this.name = name;
        this.phone = phone;
        this.stage = stage;
    }
    
    public String getTablelNumber() { return tablelNumber; }

    public String getName() { return name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public int getStage() { return stage; }
    public void setStage(int stage) { this.stage = stage; }
    
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("(");
        sBuilder.append(tablelNumber);
        sBuilder.append(": ");
        sBuilder.append(name);
        sBuilder.append(", ph: ");
        sBuilder.append(phone);
        sBuilder.append(", st: ");
        sBuilder.append(stage);
        sBuilder.append(")");
        return sBuilder.toString();
    }
}
