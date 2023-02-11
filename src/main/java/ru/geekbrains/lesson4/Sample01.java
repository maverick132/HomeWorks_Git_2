package ru.geekbrains.lesson4;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Sample01 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("abc", "Hello, GeekBrains!");
        map.put("abc1", "Hello, GeekBrains!");
        map.put("abc", "Hello, GeekBrains!");

        MyHashTable<Integer, String> myTable = new MyHashTable<>();
        myTable.put(1, "Value 1");
        myTable.put(2, "Value 2");
        myTable.put(3, "Value 3");
        myTable.put(2, "Value 2");
        myTable.remove(2);
        String value1 = myTable.get(3);
        String value2 = myTable.get(23);
    }

}

