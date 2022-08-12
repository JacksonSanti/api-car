package caregistersystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import caregistersystem.DTOS.CarDTO;
import caregistersystem.Services.CarService;
import caregistersystem.models.CarModel;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class CarController {
	
	@Autowired
	CarService carService;

	@PostMapping("/car")
	public ResponseEntity<Object> createCar(@RequestBody @Valid CarDTO carDTO){
		var carModels = new CarModel();
		BeanUtils.copyProperties(carDTO, carModels);
		return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carModels));
	}
	
	@GetMapping("/car")
	public ResponseEntity<List<CarModel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
	}	
	
	@GetMapping("/car/{id}")
	public ResponseEntity<Object> getOne(@PathVariable(value= "id") Integer id ){
		Optional<CarModel> carModelOptional = carService.findOne(id);
		if(!carModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(carModelOptional.get());
	}
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable(value= "id")Integer id){
		Optional<CarModel> carModelOptional = carService.findOne(id);
		if(carModelOptional.isPresent()) {
			carService.delete(carModelOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Car successfully deleted");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car is not found to delet");
	}
	
}
