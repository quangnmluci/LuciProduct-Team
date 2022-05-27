package org.example.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@javax.persistence.Entity
@Table(name = "user")
@Data
@Getter
@Setter
public class Entity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String email;
}