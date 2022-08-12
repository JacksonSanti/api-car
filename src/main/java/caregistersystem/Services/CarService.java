package caregistersystem.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caregistersystem.Repositories.CarRepository;
import caregistersystem.models.CarModel;

@Service
public class CarService{

	@Autowired
	CarRepository carRepository;

	public CarModel save(CarModel carModels) {
		return carRepository.save(carModels);
		
	}

	public List<CarModel> findAll() {
		return carRepository.findAll();
	}

	public Optional<CarModel> findOne(Integer id) {
		return carRepository.findById(id);
	}

	public void delete(CarModel carModel) {
		carRepository.delete(carModel);
		
	}	
	
	
	
	
}
