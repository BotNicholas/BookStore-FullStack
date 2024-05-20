package org.teamwork.spring.bookstoremvcrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "IDNP must be specified!")
    @Pattern(regexp = "^\\d{13}$", message = "IDNP must be of type 1234567890123!")
    @Length(min = 13, max = 13, message = "IDNP must have 13 digits!")
    private String idnp;
    @NotEmpty(message = "Specify the name!")
    private String name;
    @NotEmpty(message = "Specify address!")
    private String address;
    @NotEmpty(message = "Specify phone!")
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Number must be in format +373xxxxxxxx")
    private String phone;
    @NotEmpty(message = "Specify email!")
    @Pattern(regexp = "^.+@.+\\..+$", message = "Email must have next pattern: example@gmail.com")
    private String email;
    @OneToMany(mappedBy = "costumer", cascade = {CascadeType.DETACH,
                                                 CascadeType.MERGE,
                                                 CascadeType.PERSIST,
                                                 CascadeType.REFRESH})
    private List<Order> orders;

    public Costumer() {
        name = "unset";
        idnp = "0000000000000";
        address = "unset";
        phone = "+37300000000";
        email = "#unset#@gmail.com";
        orders = new ArrayList<>();
    }

    public Costumer(String name) {
        idnp = "0000000000000";
        address = "unset";
        phone = "+37300000000";
        email = "#unset#@gmail.com";
        this.name = name;
        orders = new ArrayList<>();
    }

    public Costumer(String idnp, String name, String address, String phone, String email) {
        this.idnp = idnp;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        orders = new ArrayList<>();
    }

    public Costumer(Integer id, String idnp, String name, String address, String phone, String email) {
        this.id = id;
        this.idnp = idnp;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", idnp='" + idnp + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}