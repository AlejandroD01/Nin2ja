package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ale
 */
@Repository("iRepositoryUser")
public interface IRepositoryUser extends JpaRepository<User, Serializable> {//<tipo_de_entidad, tipo_de_id>

    public abstract User findByUsername(String username);
}
