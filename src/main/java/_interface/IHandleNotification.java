package _interface;

import java.io.PrintStream;

public interface IHandleNotification {
    String getName();

    default void handleErr(Object e) {
        out(System.err, e);
    }

    default void handleOut(Object e) {
        out(System.out, e);
    }

    private void out(PrintStream out, Object e) {
        out.println(getName() + ": " + e);
    }
}
