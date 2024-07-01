package com.example.testcontainers_demo.repositories

import jakarta.persistence.criteria.CriteriaBuilder.In
import org.springframework.data.jpa.repository.JpaRepository
import com.example.testcontainers_demo.entities.UserEntity
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int>