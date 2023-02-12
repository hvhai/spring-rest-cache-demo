package com.codehunter.springrestcachedemo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDAORepository extends JpaRepository<PersonDAO, Long> {
    String PERSON_CACHE_KEY = "person";

    @Cacheable(value = PERSON_CACHE_KEY, key = "#root.methodName")
    List<PersonDAO> findAll();

    @Override
    @CacheEvict(value = PERSON_CACHE_KEY , allEntries = true)
    <S extends PersonDAO> S save(S personDAO);

    @Override
    @Cacheable(value = PERSON_CACHE_KEY, key = "#id")
    Optional<PersonDAO> findById(Long id);
}