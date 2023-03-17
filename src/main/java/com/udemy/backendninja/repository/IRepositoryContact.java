package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**@author Ale */
@Repository("iRepositoryContact")
public interface IRepositoryContact extends JpaRepository<Contact, Serializable> {//<tipo_de_entidad, tipo_de_id>

     
}
