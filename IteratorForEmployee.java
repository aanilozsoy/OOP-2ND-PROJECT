import java.util.Arrays;
import java.util.Iterator;

public class IteratorForEmployee implements EmployeeIterator {

    EmployeeAbstract[] list ;
    private int ArrayValue = 0;

    public IteratorForEmployee(){

        list = new EmployeeAbstract[1000];
        // PDF Dökümanında istendiği üzere Arraylist kullanmadan
        // Array tabanlı bir iterator deseni tanımladık.

    }

    public void addEmployeeList(EmployeeAbstract employee){
        // Employee tabanlı nesneleri Array'e ekleyip index değerlerini 1 arttırdık.
        list[ArrayValue] = employee;
        ArrayValue++;
    }

    @Override
    public Iterator createIterator() {
        return Arrays.asList(list).iterator();
    }
}
