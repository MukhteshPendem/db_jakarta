package org.ecommerce.dbmgmt.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.ecommerce.dbmgmt.keys.CompositeKey;
import org.ecommerce.dbmgmt.model.Task;
import org.ecommerce.dbmgmt.model.TaskImpl;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private final EntityManagerFactory entityManagerFactory;

    public TaskRepositoryImpl(EntityManagerFactory entityManagerFactory) {

        this.entityManagerFactory = entityManagerFactory;


    }

    @Override
    public void save(Task task) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();

        }

        catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public Task findByTitle(Task task) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM TaskImpl t WHERE t.id.title = :title", Task.class);

            System.out.println(task.getCompositeKey());

            query.setParameter("title", task.getCompositeKey().getTitle());
            Task foundTask = query.getSingleResult();
            entityManager.getTransaction().commit();

            return foundTask;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
       return new TaskImpl();
    }

    @Override
    public List<Task> findAll() {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

           TypedQuery<Task> query=  entityManager.createQuery("SELECT T FROM TaskImpl T", Task.class);

           return query.getResultList();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void update(Task task) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            entityManager.merge(task);
            entityManager.getTransaction().commit();
        }

        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Task task ) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            TaskImpl foundTask = entityManager.find(TaskImpl.class, task.getCompositeKey());
            entityManager.remove(foundTask);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
}
