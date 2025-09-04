package com.cts.productapp.repository;


import com.cts.productapp.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository{

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    static class ProductRowMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getDouble("price"));
        }
    }

    public List<Product> getAllProducts(){
        String sql = "select * from product";
        return jdbcTemplate.query(sql,new ProductRowMapper());
    }




}
