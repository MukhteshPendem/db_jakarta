package org.ecommerce.dbmgmt.model;

import org.ecommerce.dbmgmt.keys.CompositeKey;

import java.time.LocalDate;

public interface Task {

//        String getTitle();
        String getDescription();
        TaskStatus getStatus();
        LocalDate getDueDate();
        TaskPriority getPriority();
        CompositeKey getCompositeKey();
        void setStatus(TaskStatus status);
        void setDueDate(LocalDate dueDate);
        void setPriority(TaskPriority priority);
//        void setTitle(String title);
        void setDescription(String description);
        void setCompositeKey(CompositeKey compositeKey);


}
