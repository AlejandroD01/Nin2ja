package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ModelContactDTO;
import com.udemy.backendninja.repository.IRepositoryContact;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service("serviceImplContact")
public class ServiceImplContact implements IServiceContact {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("iRepositoryContact")
    private IRepositoryContact repo;

    @Override
    public ModelContactDTO registrar(ModelContactDTO modelContactDTO) {
        Contact contact = mapearEntidad(modelContactDTO);
        repo.save(contact);
        return mapearDTO(contact);
    }

    @Override
    public List<ModelContactDTO> list() {
        List<Contact> list = repo.findAll();
        return list.stream().map(contact -> mapearDTO(contact)).collect(Collectors.toList());
    }

    @Override
    public ModelContactDTO findByIdContact(int id) {
        Contact contact = repo.findById(id).orElse(null);
        return mapearDTO(contact);
    }

    @Override
    public void removeContact(int id) {
        repo.deleteById(id);
    }

//    convierte entidad a DTO
    private ModelContactDTO mapearDTO(Contact contact) {
        ModelContactDTO modelContactDTO = modelMapper.map(contact, ModelContactDTO.class);
        return modelContactDTO;
    }

    //convierte de DTO a entidad
    private Contact mapearEntidad(ModelContactDTO modelContactDTO) {
        Contact contact = modelMapper.map(modelContactDTO, Contact.class);
        return contact;
    }

}
