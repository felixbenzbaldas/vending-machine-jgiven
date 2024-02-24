package org.test;

public interface Timer {
    void runLater(Runnable runnable, long delayInMilliseconds);
}