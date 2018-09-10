package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*(..))")
    public void repositoryFind() {
    }

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.update(*))")
    public void repositoryUpdate() {
    }

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.delete(*))")
    public void repositoryDelete() {
    }

    @Pointcut("execution( * com.andreitop.newco.service.*Service+.find*(*))")
    public void serviceFindById() {
    }
}
