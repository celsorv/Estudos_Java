package br.celsorv.set;

import java.util.*;

public class PerformanceTest {


   public static void main(String[] args) {

      Random r = new Random();

      HashSet<Thing> hashSet = new HashSet<>();
      HashSet<Thing> treeSet = new HashSet<>();
      HashSet<Thing> linkedHashSet = new HashSet<>();

      long starttime;
      long endTime;
      long duration;

      List<String> classification = new ArrayList<>();


      /*
      --------------
      TreeSet
      --------------
      */

      starttime = System.nanoTime();

      for (int i = 0; i < 10000; i++) {
         int x = r.nextInt(10000 - 100) + 100;
         treeSet.add(new Thing(x));
      }

      endTime = System.nanoTime();
      duration = endTime - starttime;
      classification.add(String.format("%10d TreeSet", duration));



      /*
      --------------
      LinkedHashSet
      --------------
      */

      starttime = System.nanoTime();

      for (int i = 0; i < 10000; i++) {
         int x = r.nextInt(10000 - 100) + 100;
         linkedHashSet.add(new Thing(x));
      }

      endTime = System.nanoTime();
      duration = endTime - starttime;
      classification.add(String.format("%10d LinkedHashSet", duration));

      /*
      --------------
      HashSet
      --------------
      */

      starttime = System.nanoTime();

      for (int i = 0; i < 10000; i++) {
         int x = r.nextInt(10000 - 100) + 100;
         hashSet.add(new Thing(x));
      }

      endTime = System.nanoTime();
      duration = endTime - starttime;
      classification.add(String.format("%10d HashSet", duration));



      Collections.sort(classification);
      System.out.println("\n" + classification);

   }



}
