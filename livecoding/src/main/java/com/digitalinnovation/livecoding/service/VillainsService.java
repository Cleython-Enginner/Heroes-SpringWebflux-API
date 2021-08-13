package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Villains;
import com.digitalinnovation.livecoding.repository.VillainsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VillainsService {
    private final VillainsRepository villainsRepository;

    public VillainsService(VillainsRepository villainsRepository) {
        this.villainsRepository = villainsRepository;
    }

    public Flux<Villains> findAll(){

        return Flux.fromIterable(this.villainsRepository.findAll());
    }

    public  Mono<Villains> findByIdVillain(String id){

        return  Mono.justOrEmpty(this.villainsRepository.findById(id));
    }


    public Mono<Villains> save(Villains villains){
        return  Mono.justOrEmpty(this.villainsRepository.save(villains));
    }


    public Mono<Boolean> deletebyIDVillain(String id) {
        villainsRepository.deleteById(id);
        return Mono.just(true);

    }

}
