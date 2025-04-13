import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> item = new ArrayList<>();
        ArrayList<Integer> harga = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Item Belanjaan");
            System.out.println("2. Hapus Item Pilihan");
            System.out.println("3. Tampilkan Seluruh Item Belanjaan");
            System.out.println("4. Cari Item Belanjaan");
            System.out.println("0. Keluar dari program");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();
                input.nextLine();

            } catch (Exception e){
                System.out.println("Masukkan angka yang valid");
                pilihan = -1;
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Item Belanjaan: ");
                    item.add(input.nextLine());
                    System.out.print("Masukkan Harga Item Belanjaan: ");
                    harga.add(input.nextInt());
                    break;
                case 2:
                    System.out.print("Masukkan Nama Item Belanjaan yang akan dihapus: ");
                    String removeItem = input.nextLine();
                    int index = item.indexOf(removeItem);
                    if (index != -1) {
                        item.remove(index);
                        harga.remove(index);
                        System.out.println("Item Belanjaan Telah Dihapus!");
                    } else{
                        System.out.println("Tidak ada item yang di hapus harap masukkan nama item yang sesuai!!!");
                    }
                    break;
                case 3:
                    System.out.println("Seluruh Item");
                    System.out.println("============");
                    int total = 0;
                    for (int i = 0;i < item.size(); i++){
                        System.out.println(item.get(i) + " - " + "Rp" + harga.get(i));
                        total += harga.get(i);
                        System.out.println("Total Harga: Rp" + total);
                    }
                    break;
                case 4:
                    System.out.println("Masukkan Nama Item Belanjaan yang Dicari: ");
                    String itemName = input.nextLine();
                    index = item.indexOf(itemName);
                    if (index != -1) {
                        System.out.println(item.get(index) + " - " + "Rp" + harga.get(index));
                    }
                    break;
                default:
                    System.out.println("Masukkan angka yang valid");
                    break;
            }
        } while (pilihan != 0);


    }
}