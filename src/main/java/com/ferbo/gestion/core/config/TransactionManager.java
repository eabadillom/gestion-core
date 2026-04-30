package com.ferbo.gestion.core.config;

import java.util.function.Consumer;
import java.util.function.Function;
import javax.persistence.EntityManager;

public interface TransactionManager {
    <T> T executeRead(Function<EntityManager, T> action);
    <T> T executeWrite(Function<EntityManager, T> action);
    void executeVoid(Consumer<EntityManager> action);
}
