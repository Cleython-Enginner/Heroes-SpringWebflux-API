package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Villains;
import com.digitalinnovation.livecoding.repository.VillainsRepository;
import com.digitalinnovation.livecoding.service.VillainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static com.digitalinnovation.livecoding.constants.VillainsConstant.VILLAINS_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class VillainsController {
    VillainsService villainsService;

    VillainsRepository villainsRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(VillainsController.class);

    public VillainsController(VillainsService villainsService, VillainsRepository villainsRepository) {
        this.villainsService = villainsService;
        this.villainsRepository = villainsRepository;
    }

    @GetMapping(VILLAINS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Villains> getAllItems() {
        log.info("requesting the list off all villain");
        return villainsService.findAll();

    }


    @GetMapping(VILLAINS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Villains>> findByIdVillain(@PathVariable String id) {
        log.info("Requesting the villain with id {}", id);
        return villainsService.findByIdVillain(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(VILLAINS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Villains> createVillain(@RequestBody Villains villains) {
        log.info("A new Villain was Created");
        return villainsService.save(villains);

    }

    @DeleteMapping(VILLAINS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDVillain(@PathVariable String id) {
        villainsService.deletebyIDVillain(id);
        log.info("Deleting the villain with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
