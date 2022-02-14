

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String PATH = "C:\\Users\\aanil\\IdeaProjects\\OOP_Project\\girdi.txt";

        ReadTXT readTXT = new ReadTXT(PATH);
        AdapterInterface adapterInterface = new Adapter(readTXT);
        // Yukarıda Adapter Interfacesini TXT Okuması İçin Çağırdık Eğer Farklı Bir XML Dosyası Okumak İstersek
        // AdapterInterface adampterInteraface = new Adapter(ReadXML); şeklinde bir method ile çağırmamız yeterli olacaktır

        ArrayList<ArrayList<String>> data = adapterInterface.readText(PATH);
        //ReadTXT metodundan gelen tüm veriyi her satırı bir Arraylist olacak şekilde listeledik

        ArrayList<EmployeeAbstract> hierarchy_main = new ArrayList<EmployeeAbstract>();
        //Depolamak için gerekli listeleri oluşturduk.
        Director drc = new Director();
        //Main içerisinde method oluşturmak için static method kullanmamız gerekiyor. Bu da bellek kaybına sebep olacağı için
        // Tüm kullanacağımız methodları Director sınıfı içerisine yazdık. Bunları kullanmak için de boş bir constructor çağırdık.
        IteratorForEmployee iteratorForEmployee = new IteratorForEmployee();

        //Dosyadan okuduğuumz verileri position sahasına göre sınıflayarak listlerimize Director ve Officer nesnelerini ekledik.
        for (ArrayList<String> datum : data) {
            if (datum.get(0).equals("D")) {
                int salary = Integer.parseInt(datum.get(2));
                Director director = new Director(datum.get(0), datum.get(1), salary, datum.get(3));
                hierarchy_main.add(director);
            } else if (datum.get(0).equals("M")) {
                int salary = Integer.parseInt(datum.get(2));
                Officer officer = new Officer(datum.get(0), datum.get(1), salary, datum.get(3));
                hierarchy_main.add(officer);
            } else {
                System.out.println("Hatalı Girdi");
                System.exit(0);
            }
        }

        // Supervisee - Supervisor eşleşmelerini sağladık.
        drc.supervisorSet(hierarchy_main);

        for (EmployeeAbstract employeeAbstract : hierarchy_main) {
            iteratorForEmployee.addEmployeeList(employeeAbstract);
            // Ana listedeki hiyerarşik yapıyı iteratorümüze ekledik
        }

        IteratorCollection iterator_collection = new IteratorCollection(iteratorForEmployee);
        //Iteratorden yazdırma işlemini gerçekleştirdik.
        iterator_collection.showList();

        drc.costPrint("Mustafa Turksever",hierarchy_main);
        drc.costPrint("Oguz Demir",hierarchy_main);
        drc.costPrint("Ahmet Egeli",hierarchy_main);
    }

}
