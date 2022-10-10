package br.celsorv.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploArrayList {

   public static void main(String[] args) {

      List<String> nomes = new ArrayList<>();

      nomes.add("Pedro");
      nomes.add("João");
      nomes.add("Paulo");

      System.out.println(nomes);
      // output: [Pedro, João, Paulo]

      Collections.sort(nomes);

      System.out.println(nomes);
      // output: [João, Paulo, Pedro]


      // altera o elemento índice 2
      nomes.set(2, "Moisés");


      System.out.println(nomes);
      // output: [João, Paulo, Moisés]

      Collections.sort(nomes);

      System.out.println(nomes);
      // output: [João, Moisés, Paulo]


      // remve o elemento índice 1
      nomes.remove(1);

      System.out.println(nomes);
      // output: [João, Paulo]


      System.out.println(nomes.indexOf("João"));
      // output: 0

      int index = nomes.indexOf("Moisés");
      System.out.println(
         index == -1
            ? "Sorry, the element doesn't exist."
            : String.format("The element is in position %d", index)
      );

      System.out.println();

      for (String nome : nomes)
         System.out.println(nome);

      System.out.println();

      for (int i = 0; i < nomes.size(); i++) {
         String nome = nomes.get(i);
         System.out.println(nome);
      }

      nomes.clear();  // limpa a lista

      System.out.println();
      System.out.println(nomes.isEmpty());

   }


}
