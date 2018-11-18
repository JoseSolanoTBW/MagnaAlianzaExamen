package com.cenfotec.MagnaAlianza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.MagnaAlianza.domain.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long> {

	List<Cafe> findByNumeroFinca(Long id);
}
