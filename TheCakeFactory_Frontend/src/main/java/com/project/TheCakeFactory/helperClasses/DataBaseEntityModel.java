package com.project.TheCakeFactory.helperClasses;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public abstract class DataBaseEntityModel implements DataBaseEntityModelInterface {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime created;

    public DataBaseEntityModel(){
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
