public class SoNumerico<T extends Number> {

    private T value;

    public SoNumerico(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String tipo = value.getClass().toString().toUpperCase();
        return tipo.substring(tipo.lastIndexOf(".") + 1) + ": " + value;
    }

}