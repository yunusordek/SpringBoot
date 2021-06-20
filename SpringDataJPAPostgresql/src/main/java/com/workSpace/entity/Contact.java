package com.workSpace.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "CONTACT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Data
@DynamicUpdate
public class Contact {


    @Id
    @SequenceGenerator(name = "seq_contact",allocationSize = 1)
    @GeneratedValue(generator = "seq_contact",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100,name="NAME")
    private String name;

    @Column(length = 100,name="LASTNAME")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "CONTACT_ADRESS_ID")
    private List<Adress> adressList ;

    public Long getId() {
        return id;
    }

    public List<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<Adress> adressList) {
        this.adressList = adressList;
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

}
