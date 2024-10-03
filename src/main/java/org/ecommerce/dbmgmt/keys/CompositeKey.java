package org.ecommerce.dbmgmt.keys;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeKey implements Serializable {


    @Column(name = "id")
    private Long id;

    @Column(name = "task_title")
    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKey)) return false;
        return id.equals(((CompositeKey) o).id) && title.equals(((CompositeKey) o).title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "CompositeKey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
