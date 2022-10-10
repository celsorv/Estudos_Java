package br.celsorv.optionals;

import java.util.Optional;

public class ExemploOptional {

   public static void main(String[] args) {

      Optional<String> optionalString = Optional.of("Valor opcional");
      // Optional<String> optionalString = Optional.empty();
      // Optional<String> optionalString = Optional.ofNullable(null);

      // True se optionalString não nulo
      System.out.println(optionalString.isPresent());

      // True se optionalString é nulo
      System.out.println(optionalString.isEmpty());

      System.out.println("-".repeat(10));
      // se optionalString não nulo, imprime no console
      optionalString.ifPresent(System.out::println);
      System.out.println("-".repeat(10));

      optionalString.ifPresentOrElse(
         System.out::println,
         () -> System.out.println("Valor não está presente")
      );

      if (optionalString.isPresent()) {
         String valor = optionalString.get();
         System.out.println(valor);
      }

      // se optionalString não nulo, redefine valor e exibe no console
      optionalString.map((v) -> v.concat("*****")).ifPresent(System.out::println);

      // se optionalString nulo, lança exceção, caso contrário retorna valor
      String str = optionalString.orElseThrow(IllegalMonitorStateException::new);
      System.out.println(str);

   }

}
