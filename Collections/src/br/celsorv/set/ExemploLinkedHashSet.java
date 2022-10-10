package br.celsorv.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ExemploLinkedHashSet {

   /*
     LinkedHashSet (utiliza tabela hash com lista ligada)

     Complexidade O(1) para operações básicas.

     Útil quando é importante manter a ordem de inserção dos elementos,
     característica que faz desta implementação Set, a mais lentas.
   */

   public static void main(String[] args) {


      LinkedHashSet<Integer> sequencia = new LinkedHashSet<>();

      sequencia.add(16);
      sequencia.add(2);
      sequencia.add(8);
      sequencia.add(4);
      sequencia.add(1);

      System.out.println(sequencia);

      sequencia.remove(4);

      System.out.println(sequencia);

      System.out.println(sequencia.size());

      Iterator<Integer> iterator = sequencia.iterator();

      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }

      for (Integer numero : sequencia) {
         System.out.println(numero);
      }

      // sequencia.clear();

      System.out.println(sequencia.isEmpty());

   }

}
