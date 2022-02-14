import java.util.ArrayList;

public interface AdapterInterface {

    // İstediğimiz veri yapısı yalnızca okuduğu veriyi ArrayList<ArrayList<String>> şekline dönüştürecek bir sınıf.
    // olduğu için implement edilmesi gereken tek metod readText

    public ArrayList<ArrayList<String>> readText(String path);

}
