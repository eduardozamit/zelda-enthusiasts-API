package com.github.userservice.repository;
import com.github.userservice.models.ZeldaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZeldaRepository extends JpaRepository<ZeldaModel,String> {
}
