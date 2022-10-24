package com.bosonit.Ej13.crudvalidation.person.infraestructure.repository;

import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import com.bosonit.Ej13.crudvalidation.person.infraestructure.controller.output.PersonOutputFatherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class CriteriaPersonRepository {

    private EntityManager entityManager;

    private CriteriaBuilder cb;

    private CriteriaQuery cq;

    private Root root;

    public void configCriteriaPersonRepository() {

        setCb(entityManager.getCriteriaBuilder());
        setCq(cb.createQuery(Person.class));
        setRoot(cq.from(Person.class));
    }

    public List<Person> getGreaterPeopleByUser(String user) {


        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("user"), user));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByUser(String user) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("user"), user));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleByName(String name) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("name"), name));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByName(String name) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("name"), name));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleBySurname(String surname) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("surname"), surname));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleBySurname(String surname) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("surname"), surname));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleByDateCreation(Date dateCreated) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("created_date"), dateCreated));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByDateCreation(Date dateCreated) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("created_date"), dateCreated));
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }
}
