import java.util.ArrayList;

public class Adapter implements AdapterInterface{

    // Eğer yeni bir okuma yöntemi kullanmak istersek yapacağımız tek şey;

    ReadTXT readTXT;
    //ReadXML readXML;


    public Adapter(ReadTXT readTXT) {
        this.readTXT = readTXT;
    }
    // İçine koyacağımız nesneye göre yeni bir constructor yaratmak

    //public Adapter(ReadXML readXML){
    //  this.readXLM = readXML;
    // }

    // Ve altta da XML yapısına göre bir method yazmak.

    @Override
    public ArrayList<ArrayList<String>> readText(String path) {
        ArrayList<ArrayList<String>> tempList = readTXT.readText(path);
        return tempList;
    }



}
