package com.bosonit.Ej13.crudvalidation.person.infraestructure.repository;

import com.bosonit.Ej13.crudvalidation.person.domain.Person;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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

    private final EntityManager entityManager;

    private CriteriaBuilder cb;

    private CriteriaQuery cq;

    private Root root;

    public void configCriteriaPersonRepository() {

        setCb(entityManager.getCriteriaBuilder());
        setCq(cb.createQuery(Person.class));
        setRoot(cq.from(Person.class));
    }

    public List<Person> getGreaterPeopleByUser(String user, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("user"), user));

        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByUser(String user, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("user"), user));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleByName(String name, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("name"), name));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByName(String name, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("name"), name));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleBySurname(String surname, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("surname"), surname));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleBySurname(String surname, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("surname"), surname));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getGreaterPeopleByDateCreation(Date dateCreated, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.greaterThanOrEqualTo(root.get("created_date"), dateCreated));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<Person> getLessPeopleByDateCreation(Date dateCreated, String order) {

        configCriteriaPersonRepository();
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("created_date"), dateCreated));
        if(order.equals("user")){
            orderByUser();
        }

        if(order.equals("name")){
            orderByName();
        }
        TypedQuery<Person> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public void orderByUser(){
        cq.orderBy(cb.asc(root.get("user")));
    }

    public void orderByName(){
        cq.orderBy(cb.asc(root.get("name")));
    }
}
