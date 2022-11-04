package kodlama.io.rentACar.bussiness.abstracts;

import java.util.List;

import kodlama.io.rentACar.bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.requests.DeleteBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandsResponse;



public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest) throws Exception;
	void delete(DeleteBrandRequest deleteBrandRequest) throws Exception;
	boolean brandNameExist(String brandName) throws Exception;
	
}
