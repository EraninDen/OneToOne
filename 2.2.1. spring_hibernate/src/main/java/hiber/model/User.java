package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User  {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;



   @Column(name = "lastName")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}

   public User(String firstName){
      this.firstName = firstName;
   }
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(Long id, String firstName, String lastName, String email) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   @Override
   public String toString() {
      return "User{" +
              "firstName='" + firstName + '\'' +
              '}';
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
   private Car car;

   public Car getCar(){
      return car;
   }

   public void setCar(Car car){
      this.car = car;
   }
}
