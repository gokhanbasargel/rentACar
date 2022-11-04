package kodlama.io.rentACar.bussiness.concretes;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.DeleteBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.Brandrepository;
import kodlama.io.rentACar.entities.concretes.Brand;


@Service // Bu sınıf bir bussiness nesnesidir.
public class BrandManager implements BrandService{

	private Brandrepository brandRepostory;
	
	
	
	
	
	
	@Autowired
	public BrandManager(Brandrepository brandRepostory) {
		
		this.brandRepostory = brandRepostory;
	}







	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepostory.findAll();
		List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();
		
		for(Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			
			brandResponse.add(responseItem);
			
		}
		// işkuralları
		return brandResponse;
	}
	






	@Override
	public void add(CreateBrandRequest createBrandRequest) throws Exception  {
		Brand brand = new Brand();
		
		
		if(brandNameExist(createBrandRequest.getName())&&brand.getName().isEmpty()) {
			throw new Exception("Brand Name Exist");
		}
		else {
			
			brandRepostory.save(brand);
			
		}
		
		
		
		
		
		
	}

	@Override
	public boolean brandNameExist(String brandName) throws Exception {
		List<Brand> brandList = brandRepostory.findAll();
		for(Brand brand : brandList) {
			if(brand.getName().toLowerCase().matches(brandName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}







	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) throws Exception {
			
		Brand brand = new Brand();
		List <Brand> brandList1 = brandRepostory.findAll();
		for(Brand brand_ : brandList1) {
			if(deleteBrandRequest.getName() == brand_) {
				brandRepostory.delete(brand);
			}
			else {
				throw new Exception("Silinecek veri bulunamadı");
			}
		}
		
		
	}







	
	
	
	
	
	
	
	

}
