package model;

public class User {
    protected int id;
    protected String name;
    protected String role;
    protected String nim; 

    public User() {}

    public User(int id, String name, String role, String nim) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.nim = nim;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getNim() { return nim; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }
    public void setNim(String nim) { this.nim = nim; }

    public void showMenu() {
        // Default: tidak ada menu
        System.out.println("Menu tidak tersedia untuk user ini.");
    }
}
