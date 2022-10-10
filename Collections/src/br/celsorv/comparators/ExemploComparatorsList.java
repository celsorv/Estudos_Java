package br.celsorv.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploComparatorsList {

   public static void main(String[] args) {

      List<Estudante> estudantes = new ArrayList<>();

      estudantes.add(new Estudante("Pedro", 19));
      estudantes.add(new Estudante("Carlos", 23));
      estudantes.add(new Estudante("Mariana", 21));
      estudantes.add(new Estudante("João", 18));
      estudantes.add(new Estudante("Thiago", 20));
      estudantes.add(new Estudante("George", 22));
      estudantes.add(new Estudante("Larissa", 21));

      System.out.println("\n--- ordem de inserção ---");
      System.out.println(estudantes);

      estudantes.sort((e1, e2) -> e1.getIdade() - e2.getIdade());

      System.out.println("\n--- ordem natural dos números - idade ---");
      System.out.println(estudantes);

      estudantes.sort((e1, e2) -> e2.getIdade() - e1.getIdade());

      System.out.println("\n--- ordem reversa dos números - idade ---");
      System.out.println(estudantes);

      estudantes.sort(Comparator.comparingInt(Estudante::getIdade));

      System.out.println("\n--- ordem natural dos números - idade (method reference)");
      System.out.println(estudantes);

      estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

      System.out.println("\n--- ordem reversa dos números - idade (method reference)");
      System.out.println(estudantes);

      Collections.sort(estudantes);

      System.out.println("\n--- ordem natural dos números - idade (interface Comparable) ---");
      System.out.println(estudantes);

      estudantes.sort(new EstudanteOrdemIdadeReversaComparator());

      System.out.println("\n--- ordem reversa dos números - idade (interface Comparator) ---");
      System.out.println(estudantes);

   }

}
