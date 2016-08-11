package com.demo.util;

import com.demo.model.Author;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

/**
 * Converts the string representation of {@link Author} to object.
 * Required on{@link com.demo.controller.BookController}.
 *
 * @author rburawes
 */
public class AuthorPropertyEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            setValue(mapper.readValue(text, Author.class));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
