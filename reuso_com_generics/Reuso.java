public class Reuso<T> {

    private T value;

    public Reuso(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String tipo = value.getClass().toString().toUpperCase();
        return tipo.substring(tipo.lastIndexOf(".") + 1) + ": " + value;
    }

}
