package com.workSpace.service.impl;

import com.workSpace.dto.ContactDto;
import com.workSpace.entity.Adress;
import com.workSpace.entity.Contact;
import com.workSpace.repo.AdressRepository;
import com.workSpace.repo.ContactRepository;
import com.workSpace.service.ContactServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactServices {

    private final ContactRepository contactRepository;
    private final AdressRepository adressRepository;

    public ContactServiceImpl(ContactRepository contactRepository, AdressRepository adressRepository) {
        this.contactRepository = contactRepository;
        this.adressRepository = adressRepository;
    }

    @Override
    @Transactional
    public ContactDto save(ContactDto contactDto) {

        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setLastName(contactDto.getLastName());
        final Contact contactDb = contactRepository.save(contact);
        List<Adress> list = new ArrayList<>();
        /**
         * adresler istenirse foreach ilede doldurulabilir.
         contactDto.getAdressList().forEach(item -> {
         Adress adress = new Adress();
         adress.setAdress(item);
         adress.setAdressType(Adress.adressTypes.OTHER);
         adress.setActive(true);
         adress.setContact(contactDb);
         });
         */
        for (String adressInfo : contactDto.getAdressList()) {
            Adress adress = new Adress();
            adress.setAdress(adressInfo);
            adress.setAdressType(Adress.adressTypes.OTHER);
            adress.setActive(true);
            adress.setContact(contactDb);
            list.add(adress);
        }
        adressRepository.saveAll(list);
        contactDto.setId(contactDb.getId());
        return contactDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ContactDto> getAll() {
        List<Contact> contactList = contactRepository.findAll();
        List<ContactDto> contactDtos = new ArrayList<>();
        for (Contact contact : contactList) {
            ContactDto contactDto = new ContactDto();
            contactDto.setId(contact.getId());
            contactDto.setName(contact.getName());
            contactDto.setLastName(contact.getLastName());
            contactDto.setAdressList(contact.getAdressList().stream().map(Adress::getAdress).
                    collect(Collectors.toList()));
            contactDtos.add(contactDto);
            //for'la adresler tek tek de dolaşılabilir
        }
        return contactDtos;
    }

    @Override
    public Page<com.workSpace.dto.ContactDto> getAll(Pageable pageable) {
        return null;
    }
}
