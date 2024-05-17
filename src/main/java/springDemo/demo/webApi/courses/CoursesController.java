package springDemo.demo.webApi.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springDemo.demo.business.abstracts.CourseService;
import springDemo.demo.entities.Courses;

@RestController // Bu class ı Web controller olarak işaretlememiz anlamına gelir.
@RequestMapping("/api/courses") //gideceğimiz http linkini oluşturmak için kullanırız. 
public class CoursesController {
	
	//Öncelikle service clası oluşturarak service i buraya çekelim
	private CourseService courseService;

	
	
	@Autowired //Alıntıladık gibisinden bildiriyoruz.
	public CoursesController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	@GetMapping("/getall")
	public List<Courses> getAll(){
		return courseService.getAll();
	}
	
	@GetMapping("/getall/{id}")
    public Courses getLanguageById(@PathVariable int id) throws Exception {
        return courseService.getById(id);
    }
    @PostMapping("/add")
    public void add(Courses courses) throws Exception {
        courseService.add(courses);
    }@PostMapping("/remove")
    public void remove(Courses courses) throws Exception {
        courseService.remove(courses);
    }
    @PostMapping("/update")
    public void update(Courses courses) throws Exception {
        courseService.update(courses);
    }
}
