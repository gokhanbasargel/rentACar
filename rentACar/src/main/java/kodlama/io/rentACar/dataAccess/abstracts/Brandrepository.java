package kodlama.io.rentACar.dataAccess.abstracts;




import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.rentACar.entities.concretes.Brand;



public interface Brandrepository extends JpaRepository<Brand,Integer> {
	
	Brand findById(int id);
	
	
}
