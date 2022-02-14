import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTXT {

    private ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();

    public ReadTXT(String path) {
        this.liste = readText(path);
    }

    public ArrayList<ArrayList<String>> getList() {
        return liste;
    }

    public void setList(ArrayList<ArrayList<String>> list) {
        this.liste = list;
    }

    public  ArrayList<ArrayList<String>> readText(String path){
        ArrayList<ArrayList<String[]>> list = new ArrayList<ArrayList<String[]>>();

        try {
            File fileIn = new File(path);
            Scanner scan = new Scanner(fileIn);

            try {
                while (scan.hasNext()) {
                    String[] liste;
                    ArrayList<String[]> list2 = new ArrayList<String[]>();
                    String satir = scan.next();
                    liste = satir.split(",");

                    list2.add(liste);
                    list.add(list2);

                }

            } catch (NoSuchElementException e) {
                System.out.println("Dosyada başka eleman kalmadı!");

            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya konumu bulunamadı! ");
            System.exit(0);
        }

        ArrayList<ArrayList<String>> finalList = concatList(list);
        return finalList;
    }

    // Veri dosyasında hem virgül, hem de boşluk karakterleri var ve bu faktörler listede istenmeyen
    // yapılara neden oluyor bu nedenle concatList şeklinde bir method yazdık.

    public ArrayList<ArrayList<String>> concatList(ArrayList<ArrayList<String[]>> list){
        ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();

        for(int i = 0 ; i < list.size(); i+=2){
            String str = "";
            ArrayList<String> tempList = new ArrayList<String>();
            tempList.add(list.get(i).get(0)[0]);
            str = (list.get(i).get(0)[1])+ " " + (list.get(i+1).get(0)[0]);
            tempList.add(str);
            tempList.add(list.get(i+1).get(0)[1]);
            tempList.add(list.get(i+1).get(0)[2]);
            finalList.add(tempList);
        }


        return finalList;
    }



}