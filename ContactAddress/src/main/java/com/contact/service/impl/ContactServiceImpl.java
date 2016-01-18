package com.contact.service.impl;

import com.contact.dao.ContactDao;
import com.contact.dao.impl.ContactDaoImpl;
import com.contact.dto.Contact;
import com.contact.dto.ContactListDTO;
import com.contact.dto.ContactResponseDTO;
import com.contact.dto.ContactStatusType;
import com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andre_000 on 12/22/2015.
 */
public class ContactServiceImpl implements ContactService {

    private static Logger LOGGER = Logger.getLogger(ContactDaoImpl.class.getName());

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactResponseDTO createUpdateContact(Contact contact) throws Exception{
        ContactResponseDTO response = new ContactResponseDTO();
        try{
            contactDao.createUpdateContact(contact);
            response.setStatus(ContactStatusType.OK);
        }catch(Exception e){
            LOGGER.info(e.toString());
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
        }

        return response;

    }

    @Override
    public ContactResponseDTO removeContact(Contact contact) throws Exception{
        ContactResponseDTO response = new ContactResponseDTO();
        try {
            contactDao.removeContact(contact);
            response.setStatus(ContactStatusType.OK);
        }catch(Exception e){
            LOGGER.info(e.toString());
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
        }

        return response;
    }

    @Override
    public ContactResponseDTO getContact(Contact contact) throws Exception{
        ContactResponseDTO response = new ContactResponseDTO();
        try {
            contactDao.getContact(contact);
            response.setStatus(ContactStatusType.OK);
        }catch(Exception e){
            LOGGER.info(e.toString());
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
        }

        return response;
    }

    @Override
    @Transactional
    public ContactListDTO getAllContacts() throws Exception{
        ContactListDTO response = new ContactListDTO();
        try {
            response = contactDao.getAllContacts();
            System.out.println("--------Service" + response.getContacts().get(1).getFirstName() + "-------");
        }catch(Exception e){
            LOGGER.info(e.toString());
            throw e;
        }

        return response;
    }

}
