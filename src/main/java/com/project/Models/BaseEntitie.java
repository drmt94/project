package com.project.Models;

import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;

public abstract class BaseEntitie {
    private int id;

    public BaseEntitie(int id) {
        this.id = id;
    }
    public BaseEntitie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
