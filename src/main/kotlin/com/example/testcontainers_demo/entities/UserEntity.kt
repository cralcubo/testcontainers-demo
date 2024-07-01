package com.example.testcontainers_demo.entities

import jakarta.persistence.*

@Entity
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?=null,

    @Column
    val name: String,
    @Column
    val age: Int
)