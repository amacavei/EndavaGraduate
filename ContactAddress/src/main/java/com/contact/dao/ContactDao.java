package com.contact.dao;

import com.contact.dto.Contact;
import com.contact.dto.ContactListDTO;
import com.contact.dto.ContactResponseDTO;

/**
 * Created by andre_000 on 12/22/2015.
 */
public interface ContactDao {

    ContactResponseDTO getContact(Contact contact) throws Exception;
    ContactResponseDTO removeContact(Contact contact) throws Exception;
    ContactResponseDTO createUpdateContact(Contact contact) throws Exception;
    ContactListDTO getAllContacts() throws Exception;
}
