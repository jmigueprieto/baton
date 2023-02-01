package me.mprieto.baton.model;

public enum BType {
    IDENTIFIER, // could be a type or a variable
    BOOLEAN,
    STRING,
    INTEGER,
    DECIMAL,
    NULL,
    ARRAY,
    OBJECT,
    // Typing in Baton is optional by design.
    // If we don't know a task's return type,
    // then a variable containing the result
    // of the execution is of type UNKNOWN.
    UNKNOWN
}
