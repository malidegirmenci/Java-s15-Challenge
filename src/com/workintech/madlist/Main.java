package com.workintech.madlist;



public class Main {
    public static void main(String[] args) {
       MadList<Object> list = new MadList<>();
       String[] names = new String[]{"Kazım", "Efendi"};
       list.add("ali");
       list.add(5);
       list.add(5);
       list.add(12);
       list.add("ayşe");
       list.add("ali");
       list.add(names);
       list.add(names);
       list.add(new Integer[]{3,5});
       list.add(new Integer[]{3,5});

       System.out.println(list);
       System.out.println("Is arr empty?:  " + list.isEmpty());
       System.out.println("Size of arr: " + list.size());
       System.out.println("Is \"ayşe\" present in the array? : " + list.contains("ayşe"));
       System.out.println("Index of \"ayşe\": " + list.indexOf("ayşe"));
       System.out.println("Value of index: " + list.get(3));
       list.clear();
       System.out.println("Cleaned arr");
       System.out.println(list);
    }
}
