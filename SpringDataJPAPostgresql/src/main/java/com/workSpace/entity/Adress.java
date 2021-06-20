package com.workSpace.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADRESS_DB")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Data
@DynamicUpdate
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_adress",allocationSize = 1)
    @GeneratedValue(generator = "seq_adress",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name="ADRESS")
    private String adress;

    @Enumerated
    private adressTypes adressType;

    @Column(name="IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ADRESS_ID")
    private Contact contact;


    public enum adressTypes {
        HOME_ADRESS,
        WORK_ADRESS,
        OTHER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public adressTypes getAdressType() {
        return adressType;
    }

    public void setAdressType(adressTypes adressType) {
        this.adressType = adressType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
