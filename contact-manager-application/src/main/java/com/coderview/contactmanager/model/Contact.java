package com.coderview.contactmanager.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContactId")
    private Long contactId;
    @Column(name = "Name")
    private String name;
    @Column(name = "SecondName")
    private String secondName;
    @Column(name = "Work")
    private String work;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "ImageUrl")
    private String imageUrl;
    @Column(name = "Description", length = 10000)
    private String description;

    @ManyToOne
    private User user;
}
