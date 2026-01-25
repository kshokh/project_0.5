package uz.pdp;

import jakarta.annotation.Nonnull;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {


    @Override
    public void handleUncaughtException( Throwable ex, Method method, @Nonnull Object... params) {
        System.err.println("Async error in method: " + method.getName());
        System.err.println("Exception: " + ex.getMessage());
    }
}
