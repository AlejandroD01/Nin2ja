package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ModelContactDTO;
import java.util.List;
/**
 * @author Ale
 */
public interface IServiceContact {

    public abstract ModelContactDTO registrar(ModelContactDTO modelContactDTO);
    public abstract List<ModelContactDTO> list();
    public abstract void removeContact(int id );
    public abstract ModelContactDTO findByIdContact(int id );

  
}
