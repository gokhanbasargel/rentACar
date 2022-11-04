package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.DeleteBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;


@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;
	//IoC
	
	@Autowired
	public BrandsController(BrandService brandService) {
		
		this.brandService = brandService;
	}
	@GetMapping("/getAll")
	public List<GetAllBrandsResponse> getAll(){
		
		return brandService.getAll();
		
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) throws Exception {
		brandService.add(createBrandRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) throws Exception {
		brandService.delete(deleteBrandRequest);
	}
	
	
	
	

}
