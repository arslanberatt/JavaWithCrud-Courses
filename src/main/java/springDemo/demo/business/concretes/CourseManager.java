package springDemo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springDemo.demo.business.abstracts.CourseService;
import springDemo.demo.dataAccess.abstracts.CourseRepository;
import springDemo.demo.entities.Courses;


/*@Service annotation'ı aynı zamanda, bu sınıfların diğer bileşenlerle 
 * ilişkilerini belirtmek için kullanılan @Autowired annotation'ı ile 
 * birlikte de sıkça kullanılır. Bu şekilde, Spring, ilgili sınıflar 
 * arasındaki bağımlılıkları otomatik olarak çözer ve bu sınıfları 
 * birlikte çalışabilir hale getirir.*/


//Sadece class ın service olduğunu belirtiyoruz. Autowired ile kullanılması yaygın oluyor.
@Service
public class CourseManager implements CourseService{
	//courseRpository ye bağlı olmak için bir 
	//private oluşturup Methodu Overide ediyoruz.
	private CourseRepository courseRepository;

	
	public CourseManager() {
	}
	
	//Referans olarak CourseRpository yi kullanıyoruz 
	//bu yüzden Autowired olarak belirtmemiz gerekir
	@Autowired
	public CourseManager(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	

	@Override
	public Courses getById(int id) throws Exception {
		return courseRepository.getById(id);
	}

	@Override
	public void update(Courses course) throws Exception {
		courseRepository.update(course);
		
	}

	//Aynı isimde olup olmadığını kontrol eden add methodu
	@Override
	public void add(Courses course) throws Exception {
		for(Courses namecheck : courseRepository.getAll()) {
			if(namecheck.getName().equals(course.getName())){
				throw new Exception("Bu isme sahip bir kurs zaten mevcut");
			}
		}
		courseRepository.add(course);
	}

	@Override
	public void remove(Courses course) throws Exception {
        try {
            for(Courses check : courseRepository.getAll()){
                if (check.getId()==course.getId()){
                    courseRepository.remove(course);
                }
            }
        }catch (Exception e){
            System.out.println("Böyle bir kurs Mevcut değil");
  
        }
    }

	@Override
	public List<Courses> getAll() {
		return courseRepository.getAll();
	}


}







