package com.coderview.smartcontact.service;

import com.coderview.smartcontact.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findContactByUser(long userId);
}
