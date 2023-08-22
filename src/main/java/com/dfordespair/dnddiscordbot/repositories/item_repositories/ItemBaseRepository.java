package com.dfordespair.dnddiscordbot.repositories.item_repositories;

import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public interface ItemBaseRepository<T extends Item> extends JpaRepository<T, Long> {

    Optional<T> findByName(String name);

    @Query("SELECT i FROM Item i WHERE i.weight <= :weight")
    List<T> findAllByWeightLessThanOrEqualTo(@Param("weight") double weight);

    @Query("SELECT i FROM Item i WHERE i.weight >= :weight")
    Optional<T> findByWeightGreaterThanOrEqualTo(@Param("weight") double weight);

    @Query("SELECT i FROM Item i WHERE i.name LIKE %:keyword%")
    List<T> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT i FROM Item i WHERE i.isMagic = :isMagic")
    List<T> filterByMagicProperty(@Param("isMagic") boolean isMagic);

    @Query("SELECT i FROM Item i WHERE i.weight BETWEEN :weight1 AND :weight2")
    List<T> findByWeightRange(@Param("weight1")double weight1,
                                     @Param("weight2")double weight2);

    @Query("SELECT i FROM Item i ORDER BY i.weight DESC")
    List<T> sortByWeightDesc();




}
