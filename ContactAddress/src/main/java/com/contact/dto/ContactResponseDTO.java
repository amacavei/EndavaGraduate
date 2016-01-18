package com.contact.dto;

/**
 * Created by andre_000 on 12/23/2015.
 */
public class ContactResponseDTO {

    private Contact contact;
    private ContactStatusType status;

    public ContactResponseDTO() {
    }

    public ContactResponseDTO(ContactStatusType status) {
        this.status = status;
    }

    public ContactResponseDTO(Contact contact, ContactStatusType status) {
        this.contact = contact;
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactStatusType getStatus() {
        return status;
    }

    public void setStatus(ContactStatusType status) {
        this.status = status;
    }
}
