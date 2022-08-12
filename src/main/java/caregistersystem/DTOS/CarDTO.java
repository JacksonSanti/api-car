package caregistersystem.DTOS;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CarDTO {
	
	@NotBlank
	private String modelCar;
	
	@NotBlank
	private String color;
	
	@NotBlank
	private String onwerCar;

}
