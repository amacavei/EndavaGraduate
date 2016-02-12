package com.contact.dao.impl;

import com.contact.dao.ContactDao;
import com.contact.dto.Contact;
import com.contact.dto.ContactListDTO;
import com.contact.dto.ContactResponseDTO;
import com.contact.dto.ContactStatusType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andre_000 on 12/22/2015.
 */

@Repository
public class ContactDaoImpl implements ContactDao {

    private static Logger LOGGER = Logger.getLogger(ContactDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ContactResponseDTO createUpdateContact(Contact contact) throws Exception{
        ContactResponseDTO response = new ContactResponseDTO();
        try{
            sessionFactory.getCurrentSession().saveOrUpdate(contact);
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
            sessionFactory.getCurrentSession().delete(contact);
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
        sessionFactory.getCurrentSession().contains(contact);
            response.setStatus(ContactStatusType.OK);
        }catch(Exception e){
            LOGGER.info(e.toString());
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
        }

        return response;
    }

    @Override
    public ContactListDTO getAllContacts() throws Exception{
        ContactListDTO response = new ContactListDTO();
        try {

            Query q = sessionFactory.getCurrentSession().createQuery("from contacts");
            System.out.println("--------DAO list" + q.list().size() + "-------");
            response.setContacts(q.list());
            System.out.println("--------DAO" + response.getContacts() + "-------");
        }catch(Exception e){
            LOGGER.info(e.toString());
            throw e;
        }

        return response;
    }


}
