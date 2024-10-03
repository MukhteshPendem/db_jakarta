package org.ecommerce.dbmgmt.repository;

import org.ecommerce.dbmgmt.keys.CompositeKey;
import org.ecommerce.dbmgmt.model.Task;
import org.ecommerce.dbmgmt.model.TaskImpl;

import java.util.List;

public interface TaskRepository {


    void save(Task task);

    Task findByTitle(Task task);

    List<Task> findAll();

    void update(Task task);

    void delete(Task task);
}
