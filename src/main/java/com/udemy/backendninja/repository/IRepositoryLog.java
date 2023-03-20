package com.udemy.backendninja.repository;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ale
 */
@Repository("iRepositoryLog")
public interface IRepositoryLog extends JpaRepository<Log, Serializable> {//<tipo_de_entidad, tipo_de_id>

}
