package com.javarush.task.task19.task1904;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws Exception;

    void close() throws IOException;
}
