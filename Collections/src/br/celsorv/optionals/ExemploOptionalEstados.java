package br.celsorv.optionals;

import java.util.Optional;

public class ExemploOptionalEstados {

   /*
      ifPresentOrElse(<açãoPresent>, <açãoElse>):

      se optional diferente de null => executa açãoPresent
      se optional igual null => executa açãoElse

      Obs:
      System.out::Println é o mesmo que (value) => System.out.println(value)
    */

   public static void main(String[] args) {

      // Certeza de valor não nulo, use Optional.of
      Optional<String> optionalString = Optional.of("Valor presente");

      System.out.println("\nValor opcional está presente");
      optionalString.ifPresentOrElse(
         System.out::println, () -> System.out.println("não está presente")
      );

      // Se há dúvida se valor pode ser nulo, use Optional.ofNullable
      Optional<String> optionalNull = Optional.ofNullable(null);

      System.out.println("\nValor opcional que não está presente");
      optionalNull.ifPresentOrElse(
         System.out::println, () -> System.out.println("null = não está presente")
      );

      // Certeza de valor nulo, use Optional.empty
      Optional<String> emptyOptional = Optional.empty();

      System.out.println("\nValor opcional que não está presente");
      emptyOptional.ifPresentOrElse(
         System.out::println, () -> System.out.println("empty = não está presente")
      );

      Optional<String> optionalNullErro = Optional.of(null);

      System.out.println("\nValor opcional que lança erro NullPointerException");
      optionalNullErro.ifPresentOrElse(
         System.out::println, () -> System.out.println("erro = não está presente")
      );

   }


}
