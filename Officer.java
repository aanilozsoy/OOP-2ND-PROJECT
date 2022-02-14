public class Officer extends EmployeeAbstract{

    public Officer(String position, String name, int salary, String supervisor) {
        //Ekstra bir gereksinim olmadığı için Abstract sınıfında aynı metodlarını kullandık.
        super(position, name, salary, supervisor);
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Override
    public String getSupervisor() {
        return super.getSupervisor();
    }

    @Override
    public void setSupervisor(String supervisor) {
        super.setSupervisor(supervisor);
    }




}
