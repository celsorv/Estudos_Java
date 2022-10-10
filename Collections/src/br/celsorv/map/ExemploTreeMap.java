package br.celsorv.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExemploTreeMap {

   /*
     TreeMap (utiliza árvore rubro-negra)
     Muito semelhante ao TreeSet
    */

   public static void main(String[] args) {

      TreeMap<String, String> treeCapitais = new TreeMap<>();

      treeCapitais.put("RS", "Porto Alegre");
      treeCapitais.put("SC", "Florianópolis");
      treeCapitais.put("PR", "Curitiba");
      treeCapitais.put("SP", "São Paulo");
      treeCapitais.put("RJ", "Rio de Janeiro");
      treeCapitais.put("MG", "Belo Horizonte");

      System.out.println(treeCapitais);

      // retorna a primeira capital no topo da árvore
      System.out.println(treeCapitais.firstKey());

      // retorna a última capital no final da árvore
      System.out.println(treeCapitais.lastKey());

      // retorna a primeira capital abaixo na árvore baseado no argumento
      System.out.println(treeCapitais.lowerKey("SC"));

      // retorna a última capital acima na árvore baseado no argumento
      System.out.println(treeCapitais.higherKey("SC"));

      // retorna a primeira capital no topo da árvore
      System.out.println(
         treeCapitais.firstEntry().getKey() + " - " +
            treeCapitais.firstEntry().getValue()
      );

      // retorna a última capital no topo da árvore
      System.out.println(
         treeCapitais.lastEntry().getKey() + " - " +
            treeCapitais.lastEntry().getValue()
      );


      // retorna a primeira capital abaixo na árvore baseado no argumento
      System.out.println(
         treeCapitais.lowerEntry("SC").getKey() + " - " +
            treeCapitais.lowerEntry("SC").getValue()
      );

      // retorna a última capital acima na árvore baseado no argumento
      System.out.println(
         treeCapitais.higherEntry("SC").getKey() + " - " +
            treeCapitais.higherEntry("SC").getValue()
      );

      System.out.println("\n" + "-".repeat(40));
      System.out.println("Antes remoções:\n" + treeCapitais);
      System.out.println("-".repeat(40));


      Map.Entry<String, String> entry = treeCapitais.pollFirstEntry();
      System.out.println("\nRemove: " + entry.getKey() + " - " + entry.getValue());
      System.out.println(treeCapitais);

      entry = treeCapitais.pollLastEntry();
      System.out.println("\nRemove: " + entry.getKey() + " - " + entry.getValue());
      System.out.println(treeCapitais);

      Iterator<String> iterator = treeCapitais.keySet().iterator();

      System.out.println("\n" + "-".repeat(15));

      while (iterator.hasNext()) {
         String key = iterator.next();
         System.out.println(key + " - " + treeCapitais.get(key));
      }

      System.out.println("-".repeat(15));

      for (String capital : treeCapitais.keySet()) {
         System.out.println(capital + " - " + treeCapitais.get(capital));
      }

      System.out.println("-".repeat(15));

      for (Map.Entry<String, String> capital: treeCapitais.entrySet()) {
         System.out.println(capital.getKey() + " - " + capital.getValue());
      }

   }



}
