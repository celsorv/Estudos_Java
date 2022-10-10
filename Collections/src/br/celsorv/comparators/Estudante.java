package br.celsorv.comparators;

public class Estudante implements Comparable<Estudante> {

   private final String nome;
   private final Integer idade;

   public Estudante(String nome, Integer idade) {
      this.nome = nome;
      this.idade = idade;
   }

   public String getNome() {
      return nome;
   }

   public Integer getIdade() {
      return idade;
   }

   @Override
   public String toString() {
      return nome + " - " + idade;
   }

   @Override
   public int compareTo(Estudante o) {

      /*
         return:
            > 0, indica que objeto atual é maior que objeto argumento
            < 0, indica que objeto atual é menor que objeto argumento
            = 0, indica que objeto atual é igual ao  objeto argumento
      */

      return this.getIdade() - o.getIdade();
   }

}
