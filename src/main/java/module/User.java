package src.main.java.module;

public class User {

    private String name;
    private int age;
    private String address;
    private String phone;

    public User(String name, int age, String address, String phone) {
        validateUserData(name, age, address, phone);
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    private void validateUserData(String name, int age, String address, String phone) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
    }

    // Factory method for creating users
    public static User createUser(String name, int age, String address, String phone) {
        return new User(name, age, address, phone);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User: " + name + "\nAge: " + age + "\nAddress: " + address + "\nPhone: " + phone;
    }
}