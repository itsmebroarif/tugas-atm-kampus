// Alfiana
// Import komponent untuk bagian bagian yang kita butuhkan didalam aplikasi seperti contoh arrayList Dan Juga Scanner

// Fungsi Dari arrayList = menambah data baru secara dinamis tanpa harus menentukan ukurannya di awal

// Fungsi dari Scanner = kelas untuk melakukan masukan dari keyboard berbasis DOS atau Disk operating system yang biasa digunakan pada komputer lawas / sistem yang berbentuk Cli (command line interface)/ terminal
import java.util.ArrayList;
import java.util.Scanner;

// Function public class hanya dapat bisa dilihat oleh user
public class atmApps {
    // variabel khusus yang sudah tidak bisa ubah
    private static final int PIN = 321654987;
    // variabel yang masih bisa diubah
    private static double balance = 500;
    // Untuk melist history transaksi
    private static ArrayList<Double> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        // menginput data
        Scanner scanner = new Scanner(System.in);
        // menamnpilkan variabel
        System.out.println("Selamat datang di ATM!");
        // menampilkan variabel
        System.out.println("\n=================");
        System.out.print("Masukkan PIN Anda: ");
        System.out.println("\n=================");

        // Menginput data
        int enteredPIN = scanner.nextInt();

        // Menampilkan hasil yang benar
        if (authenticatePIN(enteredPIN)) {
            System.out.println("\n=================");
            System.out.println("Autentikasi berhasil.");
            System.out.println("\n=================");
            showMenu(scanner);

            // Menampilkan hasil yang salah
        } else {
            System.out.println("\n=================");
            System.out.println("PIN salah. Program berakhir.");
            System.out.println("\n=================");
        }
    }

    // Function jika pin benar akan lanjut ke tahap berikutnya jika salah tidak akan
    // bisa melanjutkan ke tahap berikutnya
    private static boolean authenticatePIN(int enteredPIN) {
        return enteredPIN == PIN;
    }

    // Fiko
    // Function untuk menampilkan menu didalam aplikasi, disini kita bisa memilih menu yang ingin kita tuju dengan menggunakan switch case. fitur ini digunakan agar dapat merekayasa seperti sistem atm yang asli
    private static void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSelamat datang di aplikasi ATM:");
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
            // Function untuk memilih case
            switch (choice) {
                // Function sebagai tempat opsi pemilihan menu = Mengecek Saldo Saat Ini
                case 1:
                    checkBalance();
                    break;
                // Function sebagai tempat opsi pemilihan menu = Mengambil Saldo / menarik saldo
                case 2:
                    withdraw(scanner);
                    break;
                // Function sebagai tempat opsi pemilihan menu = menaruh atau menambah saldo
                // kedalam riwayat transaksi
                case 3:
                    deposit(scanner);
                    break;
                // Function sebagai tempat opsi pemilihan menu = melihat riwayat transaksi yang
                // terjadi didalam
                case 4:
                    showTransactionHistory();
                    break;
                // Function sebagai tempat opsi pemilihan menu
                case 5:
                    System.out.println("Terima kasih telah menggunakan ATM. Program berakhir.");
                    break;
                // Pilihan yang tidak ada dimenu
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 5);
    }

    // Rizki
    // Function menampilkan menampilkan saldo didalam aplikasi jika saldo bertambah atau berkurang, maka akan tampil didalam function ini
    private static void checkBalance() {
        System.out.println("Saldo Anda saat ini: RP. " + balance);
    }

    // Arif
    // Function untuk menginput data untuk pemarikan dana, jika saldo mencukupi maka angka akan berkurang jika tidak maka akan ada peringatan jika saldo yang ingin ditarik tidak cukup
    private static void withdraw(Scanner scanner) {
        System.out.print("Masukkan jumlah uang yang ingin ditarik: RP. ");
        double amount = scanner.nextDouble();

        // Menampilkan hasil yang benar
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(-amount);
            System.out.println("Penarikan berhasil.");
            // Menampilkan hasil yang salah
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }

    // Bintang
    // Function menginput data angka yang ingin di setor kedalam penyimpanan uang
    private static void deposit(Scanner scanner) {
        System.out.print("Masukkan jumlah uang yang ingin disetor: RP. ");
        double amount = scanner.nextDouble();

        balance += amount;
        transactionHistory.add(amount);
        System.out.println("Setor tunai berhasil.");
    }

    // Galuh
    // Function menampilkan riwayat transaksi penarikan dan penyetoran dana bisa dilihat disini karena selama kita memakai aplikasi ini kita mempunyai penyimpanan untuk melihat kegiatan transaksi apa saja yang sudah kita kerjakan
    private static void showTransactionHistory() {
        System.out.println("Riwayat Transaksi:");
        for (double transaction : transactionHistory) {
            // Menampilkan penarikan
            if (transaction < 0) {
                System.out.println("Penarikan: RP. " + Math.abs(transaction));
                // Menampilkan setor tunai
            } else {
                System.out.println("Setor tunai: RP. " + transaction);
            }
        }
    }
}
