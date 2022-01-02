import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Reuso> lista = new ArrayList<>();

        lista.add(new Reuso<>("casa"));
        lista.add(new Reuso<>(10));
        lista.add(new Reuso<>(10.0));
        lista.add(new Reuso<>(10.0f));
        lista.add(new Reuso<>(new Date()));

        System.out.println("\n" + "-".repeat(35));
        lista.forEach(System.out::println);
        System.out.println("-".repeat(35) + "\n");

        // Tipo String não é aceito
        // SoNumerico<String> obj = new SoNumerico<>("""");

        SoNumerico<Long> l = new SoNumerico<Long>(17L);
        System.out.println(l + "     <<- Objeto da Classe 'SoNumero'\n");

    }

}
