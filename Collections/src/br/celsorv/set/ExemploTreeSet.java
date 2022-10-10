package br.celsorv.set;

import java.util.Iterator;
import java.util.TreeSet;

public class ExemploTreeSet {


   /*
     TreeSet (utiliza árvore rubro-negra)

     Complexidade O(log (n)) para add, remove e contains.

     Útil quando é necessário alterar a ordem através do uso de comparators.
     É uma implementação performática para leitura, contudo, nas modificações
     é necessário reordenar, tornando-a nesse aspecto mais lenta que a
     implementação LinkedHashSet.
   */

   public static void main(String[] args) {

      TreeSet<String> capitais = new TreeSet<>();

      capitais.add("Porto Alegre");
      capitais.add("Florianópolis");
      capitais.add("Curitiba");
      capitais.add("São Paulo");
      capitais.add("Rio de Janeiro");
      capitais.add("Belo Horizonte");

      System.out.println(capitais);

      // retorna a primeira capital no topo da árvore
      System.out.println("First    : " + capitais.first());

      // retorna a última capital no final da árvore
      System.out.println("Last     : " + capitais.last());

      // retorna a primeira capital abaixo na árvore com base no argumento
      System.out.println("Lower    : " + capitais.lower("Florianópolis"));

      // retorna a primeira capital acima na árvore com base no argumento
      System.out.println("Higher   : " + capitais.higher("Florianópolis"));

      // equivalente ao método first, porém, remove o elemento
      System.out.println("\npollFirst: " + capitais.pollFirst());

      System.out.println("After pollFirst: \n" + capitais);

      // equivalente ao método last, porém, remove o elemento
      System.out.println("\npollLast : " + capitais.pollLast());

      System.out.println("After pollLast: \n" + capitais + "\n");

      Iterator<String> iterator = capitais.iterator();

      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }

      System.out.println();

      for (String capital : capitais) {
         System.out.println(capital);
      }

   }



}
