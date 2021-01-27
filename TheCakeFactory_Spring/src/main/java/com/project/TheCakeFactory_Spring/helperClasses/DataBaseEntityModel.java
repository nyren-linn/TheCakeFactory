package com.project.TheCakeFactory_Spring.helperClasses;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public abstract class DataBaseEntityModel implements DataBaseEntityModelInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
