package springDemo.demo.business.abstracts;

import java.util.List;

//Tabii, bu interface bir şablon veya sözleşmedir. 
//Kurs işlemlerini gerçekleştiren herhangi bir sınıfın uygulaması 
//gereken yöntemleri belirtir. Örneğin, tüm kursları getirmek 
//için "getAll()" yöntemi tanımlanmıştır. Bu sayede, farklı 
//sınıflar aynı arayüzü kullanarak aynı türde işlemleri 
//gerçekleştirebilir, bu da kodun daha modüler ve esnek olmasını sağlar.
import springDemo.demo.entities.Courses;

public interface CourseService {
	List<Courses> getAll();
	
	//Somut ifadeler ile sırasıyla id ile çağırma güncelleme ekeleme ve kaldırma metodlarını ekliyoruz.
	Courses getById(int id) throws Exception;
	void update(Courses course) throws Exception;
	void add(Courses course) throws Exception;
	void remove(Courses course) throws Exception;
}
