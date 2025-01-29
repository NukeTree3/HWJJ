package com.nuketree3.example.service;

import com.nuketree3.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DBService {
    private SessionFactory sessionFactory;
    public void init(){
        this.sessionFactory = new Configuration().addAnnotatedClass(com.nuketree3.example.model.Person.class).buildSessionFactory();
    }
    public Person getPerson(int id){
        Person person = null;
        try(Session session = sessionFactory.openSession()){
            Query<Person> query = session.createQuery("from Person where id = :id");
            person = (Person) query.setParameter("id", id).uniqueResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> getAllPersons(){
        List<Person> persons = null;
        try(Session session = sessionFactory.openSession()){
            Query<Person> query = session.createQuery("from Person");
            persons = query.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return persons;
    }

    public void add(Person person){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Person person){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Person person = getPerson(id);
            session.delete(person);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(Person person){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(int id, String name, int age){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Person person = getPerson(id);
            person.setName(name);
            person.setAge(age);
            session.update(person);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
