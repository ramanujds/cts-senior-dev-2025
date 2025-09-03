package com.cts.productapp.repository;

import com.cts.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNameIgnoreCase(String name);

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query(value = "from Product where price between :min and :max")
    List<Product> findByPriceRange(double min, double max);

    @Query(value = "select * from Product where price between :min and :max", nativeQuery = true)
    List<Product> findByPriceRangeNative(double min, double max);

}
