package uz.pdp;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {


    @Async
    public CompletableFuture<String> create( String name) {
        if (name == null) {
            throw new AsyncOperationException("Name cannot be null");
        }
        return CompletableFuture.completedFuture("User created: " + name);
    }
}