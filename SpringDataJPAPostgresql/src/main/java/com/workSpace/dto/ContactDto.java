package com.workSpace.dto;

import lombok.Data;
import java.util.List;

@Data
public class ContactDto {
    private Long id;

    private String name;

    private String lastName;

    private List<String> adressList ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<String> adressList) {
        this.adressList = adressList;
    }
}
