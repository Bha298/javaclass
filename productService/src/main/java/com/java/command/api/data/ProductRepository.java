package com.java.command.api.data;
import org.axonframework.spring.config.NoBeanOfType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




public interface ProductRepository extends JpaRepository<Product,String> {
}
