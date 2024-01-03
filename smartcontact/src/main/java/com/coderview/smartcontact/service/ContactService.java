package com.coderview.smartcontact.service;

import com.coderview.smartcontact.model.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {

    // Now Pagination work start
    // per page contact sow = 5 [n]
    // current page = 0 [page]
    Page<Contact> findContactByUser(long userId, Integer page);
}
