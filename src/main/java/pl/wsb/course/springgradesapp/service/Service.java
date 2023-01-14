package pl.wsb.course.springgradesapp.service;
import java.util.List;

public interface Service<T> {

    List<T> getAll();
    void add(T entity);
    void delete(Long id);
    T get(Long id);
}
