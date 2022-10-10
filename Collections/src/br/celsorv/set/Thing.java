package br.celsorv.set;

public class Thing implements Comparable<Thing> {

   int id;

   public Thing(int id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return id + "";
   }

   @Override
   public int compareTo(Thing o) {
      return id - o.id;
   }

}
