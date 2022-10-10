package br.celsorv.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploHashSet {

   /*
     HashSet (utiliza tabela hash)

     Complexidade O(1).

     Útil quando não é necessário manter uma ordenação. Por não
     aceitar repetição de valores e não ser ordenada, é a mais
     performática das implementações.
   */

   public static void main(String[] args) {

      Set<Double> notas = new HashSet<>();

      notas.add(5.2);
      notas.add(9.5);
      notas.add(6.3);
      notas.add(10.0);
      notas.add(5.4);
      notas.add(7.6);
      notas.add(3.5);
      notas.add(4.1);

      System.out.println(notas);

      notas.remove(3.5);

      System.out.println(notas);

      System.out.println(notas.size());

      Iterator<Double> iterator = notas.iterator();
      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }

      for (Double nota : notas) {
         System.out.println(nota);
      }

      // notas.clear();

      System.out.println(notas.isEmpty());

   }


}
