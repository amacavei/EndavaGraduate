package com.contact;

import com.contact.dto.Contact;
import com.contact.dto.ContactListDTO;
import com.contact.dto.ContactResponseDTO;
import com.contact.dto.ContactStatusType;
import com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by andre_000 on 12/22/2015.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ResponseEntity<ContactResponseDTO> saveContact(@RequestBody Contact contact){
        ContactResponseDTO response = new ContactResponseDTO();
        try {
            response = contactService.createUpdateContact(contact);
            return new ResponseEntity<ContactResponseDTO>(response, HttpStatus.OK);
        }catch(Exception e){
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
            return new ResponseEntity<ContactResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllContacts(){
        ContactListDTO list = new ContactListDTO();

        try {
            list = contactService.getAllContacts();
            return new ResponseEntity<ContactListDTO>(list, HttpStatus.OK);
        }catch(Exception e){
            ContactResponseDTO response = new ContactResponseDTO();
            response.setStatus(ContactStatusType.INTERNAL_ERROR);
            return new ResponseEntity<ContactResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
