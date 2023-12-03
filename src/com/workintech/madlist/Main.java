package com.workintech.madlist;

import com.workintech.madlist.MadList;

public class Main {
    public static void main(String[] args) {
       MadList<Object> list = new MadList<>();
       list.add("veli");
       list.add(5);
       list.add(5);
       list.add(12);
       list.add("ayşe");
       list.add("veli");
       list.add(new String[]{"mahmut", "kerim"});
       list.add(new Integer[]{3,5});
       list.add(new Integer[]{3,5});
       System.out.println(list);
       System.out.println(list.indexOf("ayşe"));
    }
}
