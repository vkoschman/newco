package com.andreitop.newco.dto;

import java.io.Serializable;

public abstract class Dto implements Serializable {

    private static final long serialVersionUID = 5914366185889783660L;

    public abstract Long getId();

    public abstract void setId(Long id);
}
