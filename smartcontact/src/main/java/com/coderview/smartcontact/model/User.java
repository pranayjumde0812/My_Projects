package com.coderview.smartcontact.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "Enabled")
    private boolean enabled;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "About", length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();
}
