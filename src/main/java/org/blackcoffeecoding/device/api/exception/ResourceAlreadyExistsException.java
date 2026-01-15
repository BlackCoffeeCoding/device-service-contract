package org.blackcoffeecoding.device.api.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String resource, String field, String value) {
        super(String.format("%s с %s '%s' уже существует", resource, field, value));
    }
}