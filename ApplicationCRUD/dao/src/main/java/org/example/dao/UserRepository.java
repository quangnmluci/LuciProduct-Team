package org.example.dao;

import org.example.entity.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Entity, Integer> {
//      Page<Entity> findByAgeAndName(int age, String name);
//      Optional<Entity> findByName(String name);
}
