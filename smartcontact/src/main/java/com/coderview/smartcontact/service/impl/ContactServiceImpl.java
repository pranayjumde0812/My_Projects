package com.coderview.smartcontact.service.impl;

import com.coderview.smartcontact.model.Contact;
import com.coderview.smartcontact.repository.ContactRepo;
import com.coderview.smartcontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public List<Contact> findContactByUser(long userId) {

        List<Contact> contactListOfLoggedInUser = contactRepo.findContactsByUser(userId);
        return contactListOfLoggedInUser;
    }
}
