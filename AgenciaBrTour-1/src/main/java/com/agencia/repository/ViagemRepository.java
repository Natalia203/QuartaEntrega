package com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
