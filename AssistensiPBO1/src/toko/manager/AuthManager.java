package toko.manager;

import toko.model.Account;
import toko.model.Admin;
import toko.model.User;

import java.util.ArrayList;

public class AuthManager {
    private ArrayList<Account> daftarPengguna;

    public AuthManager() {
        this.daftarPengguna = new ArrayList<>();
    }

    public boolean isUsernameTaken(String username) {
        for (Account p : daftarPengguna) {
            if (p.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void tambahPengguna(Account pengguna) {
        daftarPengguna.add(pengguna);
    }

    public Account login(String username, String password) {
        for (Account p : daftarPengguna) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                return p;
            }
        }
        return null;
    }
}