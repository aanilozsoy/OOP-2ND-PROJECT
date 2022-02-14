import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    // Nesnelerimizi uygun şekilde denemek için mevcut methodlarda test uzayında mini-yapı tasarladık

    @Test
    void add(){

        Director drcTest1 = new Director("D","Sami Tuğal",6000,"Ruhat Bülent");
        Director drcTest2 = new Director("D","Anıl Özsoy",5000,"Root");
        Officer memurTest1 = new Officer("M","Berfin Erdoğan",4500,"Anıl Özsoy");
        Officer memurTest2 = new Officer("M","Hümeyra Şahin",5500,"Sami Tuğal");
        drcTest1.add(memurTest1);
        assertEquals(memurTest1.getName(),drcTest1.getSuperviseeList().get(0).getName());
    }

    @Test
    void costCalculate() {

        ArrayList<EmployeeAbstract> listTest = new ArrayList<>();


        Director drcTest1 = new Director("D","Sami Tuğal",6000,"Ruhat Bülent");
        Director drcTest2 = new Director("D","Anıl Özsoy",5000,"Root");
        Officer memurTest1 = new Officer("M","Berfin Erdoğan",4500,"Anıl Özsoy");
        Officer memurTest2 = new Officer("M","Hümeyra Şahin",5500,"Sami Tuğal");

        listTest.add(drcTest1);
        listTest.add(drcTest2);
        listTest.add(memurTest1);
        listTest.add(memurTest2);

        drcTest1.supervisorSet(listTest);


        assertEquals(4500,drcTest1.costCalculate("Berfin Erdoğan",listTest));
        assertEquals(9500,drcTest1.costCalculate("Anıl Özsoy",listTest));


        
    }

}