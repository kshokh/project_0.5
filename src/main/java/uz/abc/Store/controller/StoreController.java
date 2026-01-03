package uz.abc.Store.controller;

import uz.abc.Store.model.Store;
import uz.abc.Store.repository.StoreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreRepository storeRepository;

    public StoreController( StoreRepository storeRepository ) {
        this.storeRepository = storeRepository;
    }

    @PostMapping
    public Store create( @RequestBody Store store ) {
        return storeRepository.save( store );
    }

    @GetMapping
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Store getById( @PathVariable Long id ) {
        return storeRepository.findById( id ).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id ) {
        storeRepository.deleteById( id );
    }
}
