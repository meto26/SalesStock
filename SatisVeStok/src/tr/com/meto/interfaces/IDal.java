package tr.com.meto.interfaces;

import java.util.List;

public interface IDal<T> {
	
	void Insert(T entity);
	List<T> GetAll();
	List<T> GetAllParentId();
	T Delete(T entity);
	void Update(T entity);
	List<T> GetById(int id);
	
}
