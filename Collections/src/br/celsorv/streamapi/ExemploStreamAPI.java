package br.celsorv.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

   public static void main(String[] args) {

      List<String> estudantes = new ArrayList<>();

      estudantes.add("Pedro");
      estudantes.add("Thayse");
      estudantes.add("Marcelo");
      estudantes.add("Carla");
      estudantes.add("Juliana");
      estudantes.add("Thiago");
      estudantes.add("Rafael");

      System.out.println("\nContagem: " + estudantes.stream().count());
      // System.out.println("\nContagem: " + (long) estudantes.size());

      System.out.println(
         "\nMaior número de letras: " +
            estudantes.stream().max(Comparator.comparingInt(String::length))
      );

      System.out.println(
         "Menor número de letras: " +
            estudantes.stream().min(Comparator.comparingInt(String::length))
      );

      System.out.println(
         "\nCom a letra r no nome: " +
            estudantes.stream().filter(e -> e.toLowerCase().contains("r")).toList()
      );

      System.out.println("\nRetorna uma nova coleção com a quantidade de letras:\n" +
         estudantes.stream().map(e ->
            e.concat(" - ").concat(String.valueOf(e.length()))).toList()
      );

      System.out.println("\nRetorna os 3 primeiros elementos:\n" +
         estudantes.stream().limit(3).toList()
      );

      System.out.println("Retorna os elementos: " +
         estudantes.stream().peek(System.out::println).toList()
      );

      System.out.println("Retorna os elementos novamente:");
      estudantes.stream().forEach(System.out::println);
      // estudantes.forEach(System.out::println);

      // allMatch retorna true se todos os elementos atenderem à condição
      System.out.println("Todos os elementos tem W no nome?" +
         estudantes.stream().allMatch(e -> e.contains("W"))
      );

      // anyMatch retorna true se um dos elementos atenderem à condição
      System.out.println("Tem algum elemento com 'a' minúscula no nome?" +
         estudantes.stream().anyMatch(e -> e.contains("a"))
      );

      // noneMatch retorna true se nenhum dos elementos atenderem à condição
      System.out.println("Não tem nenhum elemento com 'a' minúscula no nome?" +
         estudantes.stream().noneMatch(e -> e.contains("a"))
      );

      // retorna o primeiro elemento da coleção, e havendo, exibe-o no console
      System.out.println("Retorna o primeiro elemento da coleção: ");
      estudantes.stream().findFirst().ifPresent(System.out::println);

      System.out.println("\n" + "-".repeat(50));

      System.out.println("Operação encadeada:");
      System.out.println(estudantes.stream()
            .peek(System.out::println)
            .map(e -> e.concat(" - ").concat(String.valueOf(e.length())))
            .peek(System.out::println)
            .filter(e -> e.toLowerCase().contains("r"))
//            .collect(Collectors.toList())
//            .collect(Collectors.joining(", "))
//            .collect(Collectors.toSet())
            .collect(Collectors.groupingBy(e -> e.substring(e.indexOf("-") + 1)))
      );

      System.out.println("-".repeat(50));

   }

}
