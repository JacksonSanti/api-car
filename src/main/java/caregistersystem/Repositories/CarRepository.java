package caregistersystem.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import caregistersystem.models.CarModel;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer>{

}
