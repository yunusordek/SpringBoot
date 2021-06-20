package com.workSpace.service;

import com.workSpace.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactServices {

    ContactDto save(ContactDto contactDto);

    void delete(Long id);

    List<ContactDto>  getAll();

    Page<ContactDto> getAll(Pageable pageable);
}
