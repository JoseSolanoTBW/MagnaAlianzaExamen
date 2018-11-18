package com.cenfotec.MagnaAlianza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.MagnaAlianza.domain.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Long> {

	List<Productor> findByNombreContaining(String nombre);
}
