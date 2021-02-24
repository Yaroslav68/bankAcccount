package bankAccount;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        final Account VTB = new Account("940391394", "Rusyev Yaroslav'", 228904);
        final Account.Card cardVTB = VTB.new Card("4276 8070 1492 7948");

        final Account Sber = new Account("1234234534564567", "Rusyev Yaroslav'", 9000);
        final Account.Card mir = Sber.new Card("2340 9999 1045 9326");
        final Account.Card mastercard = Sber.new Card("2402 3905 8484 1234");

        Account acc;
        Account.Card card;

        System.out.print("Выберите аккаунт банка: \n1.Сбербанк \n2.ВТБ \n3.Выход");
        int accSelection = read.nextInt();
        switch (accSelection) {
            case 1:
                acc = Sber;
                card = mastercard;
                break;
            case 2:
                acc = VTB;
                card = cardVTB;
                break;
            case 3:
                return;
            default:
                System.out.println("Введена неверная операция");
                return;
        }
        accountOperations(acc, card);
    }

    private static void deposit(Account.Card card) {
        System.out.print("Введите сумму для пополнения: ");
        int addValue = read.nextInt();
        if (addValue > 0) {
            card.add(addValue);
            System.out.println("Баланс пополнен на " + addValue + "руб.");
        } else System.out.println("Введена неверная сумма");
    }

    private static void withdraw(Account.Card card) {
        System.out.print("Введите сумму для снятия: ");
        int withdrawValue = read.nextInt();
        if (withdrawValue > 0) {
            card.withdraw(withdrawValue);
            System.out.println("С баланса снято " + withdrawValue + "руб.");
        } else System.out.println("Введена неверная сумма");
    }

    private static int accountOperations(Account acc, Account.Card card) {
        int cycle = 1;
        do {
            System.out.print("\nВыберите операцию: \n1.Пополнение \n2.Снятие \n3.Баланс счёта \n4.Выход");
            int select = read.nextInt();
            switch (select) {
                case 1:
                    deposit(card);
                    break;
                case 2:
                    withdraw(card);
                    break;
                case 3:
                    System.out.println("Баланс счёта: " + acc.getAmount());
                    break;
                case 4:
                    cycle = 0;
                    break;
                default:
                    System.out.println("Введена неверная операция");
                    break;
            }
        } while (cycle == 1);
        return 0;
    }
}