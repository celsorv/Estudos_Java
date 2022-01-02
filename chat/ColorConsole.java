public class ColorConsole {

    public static void println(String msg, ANSIColor color) {
        out(msg, color, true);
    }

    public static void print(String msg, ANSIColor color) {
        out(msg, color, false);
    }

    private static void out(String msg, ANSIColor color, boolean newLine) {
        System.out.print(String.format(newLine ? "%s%s%s%n" : "%s%s%s", color, msg, ANSIColor.RESET));
    }

}
