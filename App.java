import java.util.Scanner;

public class App {
    // UNTUK MELACAK DATA
    static int MAX_SIZE = 10;
    static int indexData = 0;

    // UNTUK MENGUMPULKAN DATA MAHASISWA
    static String[] nimMahasiswa = new String[MAX_SIZE];
    static String[] namaMahasiswa = new String[MAX_SIZE];
    static int[] aktMahasiswa = new int[MAX_SIZE];
    static String[] prodiMahasiswa = new String[MAX_SIZE];

    // Scanner
    static Scanner in = new Scanner(System.in);    

    public static void main(String[] args) { 
        char pilihan = '1';

        while(pilihan != '0') {
            System.out.println("SIAKAD - Mahasiswa");
            System.out.println("1. Tambah mahasiswa baru");
            System.out.println("2. Cari mahasiswa (berdasarkan nim)");
            System.out.println("3. Hapus mahasiswa (berdasarkan nim)");
            System.out.println("4. Tampilkan daftar mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            pilihan = in.nextLine().charAt(0); 
            switch (pilihan) {
                case '1' :
                    tambahMahasiswa();
                    break;
                case '2' :
                    cariMahasiswa();
                    break;
                case '3' :
                    hapusMahasiswa();
                    break;
                case '4' :
                    tampilkanMahasiswa();
                    break;
                case '0' :
                    return;
            }
        }

        in.close();
    }

    public static String getString(String message) {
        System.out.print(message);
        String data = in.nextLine();
        
        return data;
    }

    public static int getInt(String message) {
        System.out.print(message);
        int data = in.nextInt(); in.nextLine();
        
        return data;
    }

    public static void tekanEnter() {
        System.out.print("Tekan enter untuk melanjukan ");
        in.nextLine();
    }

    public static void tambahUkuran() {
        MAX_SIZE = MAX_SIZE * 2;
        String[] temporaryNim = new String[MAX_SIZE];
        String[] temporaryNama = new String[MAX_SIZE];
        int[] temporaryAkt = new int[MAX_SIZE];
        String[] temporaryProdi = new String[MAX_SIZE];

        for(int i = 0; i < MAX_SIZE / 2; i++) {
            temporaryNim[i] = nimMahasiswa[i];
            temporaryNama[i] = namaMahasiswa[i];
            temporaryAkt[i] = aktMahasiswa[i];
            temporaryProdi[i] = prodiMahasiswa[i];
        }

        nimMahasiswa = temporaryNim;
        prodiMahasiswa = temporaryProdi;
        aktMahasiswa = temporaryAkt;
        namaMahasiswa = temporaryNama;
    }

    public static void tambahMahasiswa() {
        if (indexData == MAX_SIZE) {
            tambahUkuran();
        }

        String nim = getString("NIM : ");
        String nama = getString("Nama : ");
        int angkatan = getInt("Angkatan : ");
        String prodi = getString("Program Studi : ");

        nimMahasiswa[indexData] = nim;
        namaMahasiswa[indexData] = nama;
        aktMahasiswa[indexData] = angkatan;
        prodiMahasiswa[indexData] = prodi;

        indexData++;
        System.out.println("-".repeat(40));
        System.out.println("Data berhasil ditambahkan\n\n");
        tekanEnter();
    }

    public static void cariMahasiswa() {
        String nim = getString("Masukkan NIM : ");
        int index = -1;
        for(int i = 0; i < MAX_SIZE; i++) {
            if (nimMahasiswa[i] == null) continue;

            if (nimMahasiswa[i].equals(nim)) {
                index = i;
            }
        }
        
        System.out.println("-".repeat(40));
        if (index == -1) {
            
            System.out.println("Data yang anda cari tidak ditemukan\n\n");
        } else {
            System.out.printf("Nama : %s\n", namaMahasiswa[index]);
            System.out.printf("Angkatan : %d\n", aktMahasiswa[index]);
            System.out.printf("Program Studi : %s\n\n\n", prodiMahasiswa[index]);
        }
        tekanEnter();
    }

    public static void hapusMahasiswa() {
        String nim = getString("Masukkan NIM : ");
        int index = -1;
        for(int i = 0; i < MAX_SIZE; i++) {
            if (nimMahasiswa[i] == null) continue;

            if (nimMahasiswa[i].equals(nim)) {
                index = i;
            }
        }
        
        System.out.println("-".repeat(40));
        if (index == -1) {
            System.out.println("Data yang anda cari untuk dihapus tidak ditemukan\n\n");
        } else {
            nimMahasiswa[index] = null;
            namaMahasiswa[index] = null;
            aktMahasiswa[index] = -1;
            prodiMahasiswa[index] = null;
            System.out.println("Data berhasil dihapus\n\n");
        }
        tekanEnter();
    }

    public static void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        System.out.printf("%-16s %-30s %-12s %-30s\n", "NIM","NAMA","ANGKATAN", "PRODI");
        for(int i = 0; i < MAX_SIZE; i++) {
            if (nimMahasiswa[i] == null) continue;
            System.out.printf("%-16s %-30s %-12s %-30s\n", 
                nimMahasiswa[i], 
                namaMahasiswa[i], 
                aktMahasiswa[i],
                prodiMahasiswa[i]
            );
        }

        System.out.println("\n");
        tekanEnter();
    }
}
