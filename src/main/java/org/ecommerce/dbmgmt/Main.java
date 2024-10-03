package org.ecommerce.dbmgmt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ecommerce.dbmgmt.keys.CompositeKey;
import org.ecommerce.dbmgmt.model.Task;
import org.ecommerce.dbmgmt.model.TaskImpl;
import org.ecommerce.dbmgmt.model.TaskPriority;
import org.ecommerce.dbmgmt.model.TaskStatus;
import org.ecommerce.dbmgmt.repository.TaskRepository;
import org.ecommerce.dbmgmt.repository.TaskRepositoryImpl;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {


    try(EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("tasks_persistence_unit")) {

        EntityManager entityManager = factory.createEntityManager();


        // -------> Composite key
        CompositeKey compositeKey = new CompositeKey();
        compositeKey.setId(3L);
        compositeKey.setTitle("Third Task");

        // --------> Task
        Task task = new TaskImpl();
        task.setCompositeKey(compositeKey);
        task.setDescription("Be Happy");
        task.setDueDate(LocalDate.of(2024, 10, 5));
        task.setPriority(TaskPriority.HIGH);
        task.setStatus(TaskStatus.PENDING);

        System.out.println(task);

        TaskRepository taskRepository = new TaskRepositoryImpl(factory);
        System.out.println(taskRepository.findByTitle(task));

    }

    }

}

