package br.celsorv.map;

import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {


   public static void main(String[] args) {

      Map<String, Integer> campoesMundialFifa = new HashMap<>();

      campoesMundialFifa.put("Brasil", 5);
      campoesMundialFifa.put("Alemanha", 4);
      campoesMundialFifa.put("Itália", 4);
      campoesMundialFifa.put("Uruguai", 2);
      campoesMundialFifa.put("Argentina", 2);
      campoesMundialFifa.put("França", 2);
      campoesMundialFifa.put("Inglaterra", 1);
      campoesMundialFifa.put("Espanha", 1);

      System.out.println(campoesMundialFifa);

      // atualiza o valor para a chave Brasil
      campoesMundialFifa.put("Brasil", 6);

      System.out.println(campoesMundialFifa);

      System.out.println("Títulos da Itália : " + campoesMundialFifa.get("Itália"));

      System.out.println("Número de Campeões: " + campoesMundialFifa.size());

      System.out.println("França foi campeã? " + campoesMundialFifa.containsKey("França"));

      System.out.println("\nFrança removida da lista");
      campoesMundialFifa.remove("França");
      System.out.println("França foi campeã? " + campoesMundialFifa.containsKey("França"));

      System.out.println("\nHá hexa campeão? " + campoesMundialFifa.containsValue(6));

      System.out.println("\n" + "-".repeat(15));

      for (Map.Entry<String, Integer> entry: campoesMundialFifa.entrySet()) {
         System.out.println(entry.getKey() + " -- " + entry.getValue());
      }

      System.out.println("-".repeat(15));

      for (String key: campoesMundialFifa.keySet()) {
         System.out.println(key + " -- " + campoesMundialFifa.get(key));
      }

      System.out.println("Tamanho do mapa: " + campoesMundialFifa.size());

      campoesMundialFifa.clear();
      System.out.println("-".repeat(30) + ">> Limpa mapa");
      System.out.println("Tamanho do mapa: " + campoesMundialFifa.size());

   }



}
