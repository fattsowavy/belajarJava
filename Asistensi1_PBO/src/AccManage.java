import java.util.Scanner;
import java.util.ArrayList;

public class RegistView {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();

        public  void registers() {
        Scanner input = new Scanner(System.in);

        System.out.println("== Register View ==");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();
        switch (pilihan) {
            case 1:
                System.out.println("Masukkan Nama: ");
                String nama = input.nextLine();
                System.out.println("Masukkan Username: ");
                String username = input.nextLine();
                System.out.println("Masukkan Password: ");
                String password = input.nextLine();
                admins.add(new Admin(username, password));
                System.out.println("Regist Berhasil");
                break;
            case 2:
                System.out.println("Masukkan Nama: ");
                nama = input.nextLine();
                System.out.println("Masukkan Username: ");
                username = input.nextLine();
                System.out.println("Masukkan Password: ");
                password = input.nextLine();
                users.add(new User(username, password));
                break;
        }
    }

    public void login(){
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan username: ");
        String username = input.nextLine();
        System.out.println("Masukkan password: ");
        String password = input.nextLine();

        for(Admin a : admins){
            if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                System.out.println("Login berhasil");
                return;
            }
        }
        System.out.println("pw / email salah");



    }

}
