package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import com.digitalinnovation.livecoding.repository.VillainsRepository;
import com.digitalinnovation.livecoding.service.HeroesService;
import com.digitalinnovation.livecoding.service.VillainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovation.livecoding.constants.HeroesConstant.VILLAINS_ENDPOINT_LOCAL;
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
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes");
        return villainsService.findAll();

    }


    @GetMapping(VILLAINS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Villains>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return villainsService.findByIdVillain(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(VILLAINS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Villains> createHero(@RequestBody Villains villains) {
        log.info("A new Hero was Created");
        return heroesService.save(villains);

    }

    @DeleteMapping(VILLAINS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDVillain(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
