package web.model;

public class User {

    private int id;

    private String username;

    private ContactInfo contactInfo;

    public User() { this.contactInfo = new ContactInfo();}

    public User(int id, String username, ContactInfo contactInfo) {
        this.id = id;
        this.username = username;
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", contactInfo=" + contactInfo +
               '}';
    }
}
