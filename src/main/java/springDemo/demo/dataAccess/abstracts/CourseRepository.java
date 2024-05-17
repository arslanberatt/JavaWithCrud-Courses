package springDemo.demo.dataAccess.abstracts;

import java.util.List;

import springDemo.demo.entities.Courses;


//Bu interface'i uygulayan sınıflar, Course entity'sine 
//erişmek ve bu entity ile ilgili işlemleri gerçekleştirmek 
//için bu yöntemleri uygulamak zorundadır.

public interface CourseRepository {
	List<Courses> getAll();
	//Somut ifadeler ile sırasıyla id ile çağırma güncelleme ekeleme ve kaldırma metodlarını ekliyoruz.
	Courses getById(int id) throws Exception;
	void update(Courses course) throws Exception;
	void add(Courses course) throws Exception;
	void remove(Courses course) throws Exception;							
}

