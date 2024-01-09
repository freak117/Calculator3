import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� �������������� ��������� � ����� ��������� ������� �� 1 �� 10 (��������, 2 + 3): ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("���������: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("������: " + e.getMessage());
        }

        scanner.close();
    }

    public static String calc(String input) {
        if (!input.matches("\\d+\\s+[-+*/]\\s+\\d+")) {
            throw new IllegalArgumentException("������������ ������ ���������.");
        }

        String[] parts = input.split("\\s+");
        int operand1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int operand2 = Integer.parseInt(parts[2]);

        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("����� ������ ���� �� 1 �� 10 ������������.");
        }

        int result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("�������� ��������. ��������� ������������ ������ '+', '-', '*' ��� '/'.");
        }

        return String.valueOf(result);
    }
}