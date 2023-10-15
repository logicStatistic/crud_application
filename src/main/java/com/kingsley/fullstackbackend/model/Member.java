package com.kingsley.fullstackbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )

    private Long id;
    private String username;
    private String name;
    private String email;
}
