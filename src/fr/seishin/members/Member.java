package fr.seishin.members;

public abstract class Member {
    private static int count = 1;

    private int id;
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private String address;

    public Member(String name, String firstName, String email, String phone, String address) {
        this.id = count;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.address = address;

        count += 1;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public String getFirstName() { return this.firstName; }
    public String getEmail() { return this.email; }
    public String getPhone() { return this.phone; }
    public String getAddress() { return this.address; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
}