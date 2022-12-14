package fr.afpajulien.apidemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Paris")
    private Date birthDate;

    // Paramêtre cascade pour persister les skills dans la BDD
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<Skill> skills = new ArrayList<>();

    // Méthode pour ajouter un skill à une personne, pas utilisée pour le moment
    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.setPerson(this);
    }

}
