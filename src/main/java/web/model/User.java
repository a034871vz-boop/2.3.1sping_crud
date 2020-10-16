package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String name;
    private String lastName;
    private String age;
    private String email;

    public User() {}

    public User(String name, String lastName, String age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "lastName")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column(name = "age")
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    @Column(name = "email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
