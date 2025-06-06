package model;

public class User {
    protected int id;
    protected String name;
    protected String role;
    protected String nim;
    protected String password;

    public User() {}

    public User(int id, String nim, String name, String password, String role) {
        this.id = id;
        this.nim = nim;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getNim() { return nim; }
    public String getPassword() { return password; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }
    public void setNim(String nim) { this.nim = nim; }
    public void setPassword(String password) { this.password = password; }

    public void showMenu() {
        // Default: tidak ada menu
        System.out.println("Menu tidak tersedia untuk user ini.");
    }
}
