import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um CPF para validar: ");
        String cpf = scanner.next();
        if (validate(cpf)) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }
    }

    public static boolean validate(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11) {
            return false;
        }
        int[] digits = cpf.chars().map(Character::getNumericValue).toArray();
        return validateDigit(digits, 9, 10) && validateDigit(digits, 10, 11);
    }

    private static boolean validateDigit(int[] digits, int pos, int multiplier) {
        int sum = IntStream.range(0, pos).map(i -> digits[i] * (multiplier - i)).sum();
        int remainder = sum % 11;
        int digit = remainder < 2 ? 0 : 11 - remainder;
        return digits[pos] == digit;
    }
}
