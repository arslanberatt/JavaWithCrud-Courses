package springDemo.demo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import springDemo.demo.dataAccess.abstracts.CourseRepository;
import springDemo.demo.entities.Courses;



//repository implementi olduğunu bildirmemiz için bu at i ekliyoruz.
@Repository
public class InMemoryCourseRepository implements CourseRepository{
	//Courses listesi
	List<Courses> courses;
	
	public InMemoryCourseRepository() {
		//Courses listesini courses olarak tanımladık
		//fakat bunu Array e çevirmeyi unutmamak lazım
		courses = new ArrayList<Courses>();
		
		//add metodu ile entity nin içinde tanımladığımız 
		//veritürlerini parentez içine doluduryoruz.
		courses.add(new Courses(1, "Java"));
		courses.add(new Courses(2, "JavaScript"));
		courses.add(new Courses(3, "C++"));
		courses.add(new Courses(4, "C"));
		courses.add(new Courses(5, "C#"));
		courses.add(new Courses(6, "NodeJs"));
		courses.add(new Courses(7, ".NET"));
	}

	@Override
	public List<Courses> getAll() {
		return courses;
	}

	//id ile bulup çekmek için 
	@Override
	public Courses getById(int id) throws Exception {
		for(Courses check : this.courses) {
			if(check.getId() == id) {
				return check;
			}
		}
		throw new Exception("Bu id de bir kurs mevcut değil");
	}

	//güncelleyebilmek için yine id bilgisine ihtiyacımız var 
	@Override
	public void update(Courses course) throws Exception {
		for (Courses check : courses) {
            if (check.getId()==course.getId()) {
                check.setName(course.getName());
            }
        }
	}

	@Override
	public void add(Courses course) throws Exception {
		courses.add(course);
	}

	@Override
	public void remove(Courses course) throws Exception {
		courses.remove(course.getId()-1);
		
	}
	
	

}
