package uz.abc.Store.controller;

import uz.abc.Store.model.Item;
import uz.abc.Store.model.Upload;
import uz.abc.Store.repository.ItemRepository;
import uz.abc.Store.repository.StoreRepository;
import uz.abc.Store.service.FileStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;
    private final FileStorageService fileService;

    public ItemController( ItemRepository itemRepository,
                           StoreRepository storeRepository,
                           FileStorageService fileService ) {
        this.itemRepository = itemRepository;
        this.storeRepository = storeRepository;
        this.fileService = fileService;
    }

    // CREATE ITEM WITH FILE UPLOAD
    @PostMapping(consumes = "multipart/form-data")
    public Item createItem(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam Long storeId,
            @RequestPart MultipartFile file ) throws Exception {

        Upload upload = fileService.upload( file );

        Item item = new Item();
        item.setName( name );
        item.setDescription( description );
        item.setPrice( price );
        item.setPath( upload.getUploadedPath() );
        item.setStore( storeRepository.findById( storeId ).orElseThrow() );

        return itemRepository.save( item );
    }

    @GetMapping
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item getById( @PathVariable Long id ) {
        return itemRepository.findById( id ).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id ) {
        itemRepository.deleteById( id );
    }
}
