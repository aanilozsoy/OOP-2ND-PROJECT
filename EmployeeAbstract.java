public abstract class EmployeeAbstract {

    private String position;
    private String name;
    private int salary;
    private String supervisor;

    // Director ve Officer sınıflarında ortak olarak kullanacağımız nesneleri yazdık.

    public EmployeeAbstract(String position, String name, int salary, String supervisor) {
        this.position = position;
        this.name = name;
        this.salary = salary;
        this.supervisor = supervisor;
    }

    public EmployeeAbstract() {
    }


    public void add(EmployeeAbstract employeeAbstract){

        throw new UnsupportedOperationException();

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}
