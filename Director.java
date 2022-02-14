import java.util.ArrayList;

public class Director extends EmployeeAbstract{

    // Memur sınıfında olmayacak olan SuperviseeList yapısını oluşturduk.
    private ArrayList<EmployeeAbstract> superviseeList = new ArrayList<EmployeeAbstract>();

    public Director() {
        super();
    }

    public Director(String position, String name, int salary, String supervisor) {
        super(position, name, salary, supervisor);
        // Consturcter kısmında herhangi bir supervisee list atamasına gerek yok. Ekleme işlemini Main sınıfı içerisinde methodla gerçekleştirdik.
    }

    @Override
    public void add(EmployeeAbstract employeeAbstract) {
        superviseeList.add(employeeAbstract);
    }


    public ArrayList<EmployeeAbstract> getSuperviseeList() {
        return superviseeList;
    }


    public String firstName(String str){
        String nameList[] = str.split(" ");
        String strFirst = nameList[0]; // Supervisorun ilk adını bir değişkene atadık
        return strFirst;
    }


    public int costCalculate(String name , ArrayList<EmployeeAbstract> list){
        // Çalışanların Maliyet Hesabını Yapan Method
        int cost = 0 ;

        for(int i = 0 ; i < list.size() ; i++){
            int maliyet = 0;
            if (list.get(i).getName().equals(name)){

                if(list.get(i).getPosition().equals("D")){
                    Director tempDirector = (Director) list.get(i);
                    for(int j = 0 ; j < tempDirector.getSuperviseeList().size() ;j++){
                        maliyet += ((Director) list.get(i)).getSuperviseeList().get(j).getSalary();
                    }
                    cost = maliyet + list.get(i).getSalary();
                }
                else if(list.get(i).getPosition().equals("M")){
                    Officer tempOfficer = (Officer) list.get(i);
                    cost =  tempOfficer.getSalary();
                }
                else{
                    System.out.println("Kullanıcı Bulunamadı.");
                    System.exit(0);
                }

            }

        }

        return cost;

    }

    public void supervisorSet(ArrayList<EmployeeAbstract> liste){

        for(int i = 0 ; i < liste.size() ; i++){
            String supervisorName = firstName(liste.get(i).getSupervisor());

            for (EmployeeAbstract employeeAbstract : liste) {

                if (employeeAbstract.getPosition().equals("D")) {

                    if (supervisorName.equals(firstName(employeeAbstract.getName()))) {
                        Director tempDirector = (Director) employeeAbstract;
                        ((Director) employeeAbstract).getSuperviseeList().add(liste.get(i));
                    }

                }

            }
        }

    }




    public void costPrint(String name , ArrayList<EmployeeAbstract> list){
        // İsime göre Maliyet Hesabı Yapan Method
        System.out.println(name + " İsimli çalışanın maliyeti : " + costCalculate(name , list));
    }

}


