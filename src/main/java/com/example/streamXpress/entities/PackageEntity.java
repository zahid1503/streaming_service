package com.example.streamXpress.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "package")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pack_id")
    private Long packId;

    @Column(name = "name")
    private String name;
}
