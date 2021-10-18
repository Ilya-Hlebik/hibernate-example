package service;

import entity.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperService {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Integer addDeveloper(String firstName, String lastName, String specialty, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = new Developer(firstName, lastName, specialty, experience);
        Integer savedId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return savedId;
    }

    public List<Developer> listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer").list();
        transaction.commit();
        session.close();
        return developers;
    }

    public void updateDeveloper(int developerId, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, developerId);
        developer.setExperience(experience);
        session.update(developer);
        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}
