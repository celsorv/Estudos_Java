package br.celsorv.map;

import java.util.Hashtable;
import java.util.Map;

public class ExemploHashtable {

   /*
     Hashtable

     Comparado ao HashMap, a diferença é que Hashtable é thread-safe (sincronizado),
     ou seja,pode ser utilizado em situações em que hava concorrência de threads.

     Sua utilização não é recomendada.
   */

   public static void main(String[] args) {

      Hashtable<String, Integer> estudantes = new Hashtable<>();

      estudantes.put("André", 21);
      estudantes.put("Marina", 33);
      estudantes.put("Rafaela", 18);
      estudantes.put("Pedro", 44);

      System.out.println(estudantes);

      estudantes.put("Pedro", 55);
      System.out.println("\nApós atualizar Pedro:\n" + estudantes);

      estudantes.remove("Pedro");
      System.out.println("\nApós remover Pedro:\n" + estudantes);

      int idadeEstudante = estudantes.get("Marina");
      System.out.println("\nIdade de Marina: " + idadeEstudante);

      System.out.println("Número de estudantes: " + estudantes.size());

      System.out.println("\n" + "-".repeat(15));

      for (Map.Entry<String, Integer> entry : estudantes.entrySet()) {
         System.out.println(entry.getKey() + " -- " + entry.getValue());
      }

      System.out.println("-".repeat(15));

      for (String key : estudantes.keySet()) {
         System.out.println(key + " -- " + estudantes.get(key));
      }


   }


}
