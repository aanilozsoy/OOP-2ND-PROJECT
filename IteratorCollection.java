import java.util.Iterator;

public class IteratorCollection {

    IteratorForEmployee iterator;
    EmployeeIterator empIterator ;


    public IteratorCollection(EmployeeIterator ite){
        empIterator = ite;
    }

    public void showList(){

        Iterator empList = empIterator.createIterator();
        printIterator(empList);

    }

    public void printIterator(Iterator iterator){

        while (iterator.hasNext()){
            EmployeeAbstract employee = (EmployeeAbstract) iterator.next();

            // Array tabanlı bir iterator pattern yazdığımız için listede yeterli eleman olmazsa kalan
            // elemanlar null şeklinde dolduruluyor ve bu elemanlar yazdırılınca hata veriyor. Bu nedenle
            // burada bir hata kontrolü yarattık.

            if (employee == null){
                break;
            }
            else{
                // Çalışanın pozisyonuna göre farklı yazdırma seçeneklerini yarattık.

                if(employee.getPosition().equals("D")){
                    Director tempDirector = (Director) employee;

                    System.out.println("Position : " + employee.getPosition()+ " | Name : " + employee.getName() +
                             " | Salary : " + employee.getSalary() + " | Supervisor : " + employee.getSupervisor() + " Altında Çalışanlar");

                    for (int i = 0 ; i < tempDirector.getSuperviseeList().size() ; i++){
                        System.out.println((i+1)+ ")" +tempDirector.getSuperviseeList().get(i).getName());
                    }

                }
                else if (employee.getPosition().equals("M")){
                    Officer tempMemur = (Officer) employee;
                    System.out.println("Position : " + employee.getPosition()+ " | Name : " + employee.getName() +
                            " | Salary : " + employee.getSalary() + " | Supervisor : " + employee.getSupervisor());
                }


            }

        }

    }


}
