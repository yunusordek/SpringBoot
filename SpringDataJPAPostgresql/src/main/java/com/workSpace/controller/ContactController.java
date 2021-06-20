package com.workSpace.controller;

import com.workSpace.dto.ContactDto;
import com.workSpace.service.ContactServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")

public class ContactController {
    private final ContactServices contactServices;



    @PostMapping
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        return ResponseEntity.ok(contactServices.save(contactDto));
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> tumunuListele() {
        return ResponseEntity.ok(contactServices.getAll());
    }


    public ContactController(ContactServices contactServices) {
        this.contactServices = contactServices;
    }

}
