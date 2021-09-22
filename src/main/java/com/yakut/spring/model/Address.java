package com.yakut.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @OneToOne(cascade = CascadeType.ALL)  //( каскад удаляет из привязанной таблицы при удалении юзера)
    @JoinColumn (name = "address_id")
    private User user;

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }
}
