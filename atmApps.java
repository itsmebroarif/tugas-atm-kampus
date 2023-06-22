import java.util.ArrayList;
import java.util.Scanner;

public class atmApps {
    private static final int PIN = 321654987;
    private static double balance = 500;
    private static ArrayList<Double> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di ATM!");
        System.out.print("Masukkan PIN Anda: ");
        int enteredPIN = scanner.nextInt();

        if (authenticatePIN(enteredPIN)) {
            System.out.println("Autentikasi berhasil.");
            showMenu(scanner);
        } else {
            System.out.println("PIN salah. Program berakhir.");
        }
    }

    private static boolean authenticatePIN(int enteredPIN) {
        return enteredPIN == PIN;
    }

    private static void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSelamat datang di aplikasi cashy:");

             System.out.println("\n=================");
            System.out.println("1. Cek Saldo");
             System.out.println("\n=================");
            System.out.println("2. Tarik Tunai");
             System.out.println("\n=================");
            System.out.println("3. Setor Tunai");
             System.out.println("\n=================");
            System.out.println("4. Riwayat Transaksi");
             System.out.println("\n=================");
            System.out.println("5. Keluar");
             System.out.println("\n=================");
            System.out.print("Masukkan pilihan Anda: ");
             System.out.println("\n=================");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan ATM. Program berakhir.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 5);
    }

    private static void checkBalance() {
        System.out.println("Saldo Anda saat ini: RP. " + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Masukkan jumlah uang yang ingin ditarik: RP. ");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(-amount);
            System.out.println("Penarikan berhasil.");
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Masukkan jumlah uang yang ingin disetor: RP. ");
        double amount = scanner.nextDouble();

        balance += amount;
        transactionHistory.add(amount);
        System.out.println("Setor tunai berhasil.");
    }

    private static void showTransactionHistory() {
        System.out.println("Riwayat Transaksi:");
        for (double transaction : transactionHistory) {
            if (transaction < 0) {
                System.out.println("Penarikan: RP. " + Math.abs(transaction));
            } else {
                System.out.println("Setor tunai: RP. " + transaction);
            }
        }
    }
}
