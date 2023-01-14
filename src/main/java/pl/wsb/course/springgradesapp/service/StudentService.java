package pl.wsb.course.springgradesapp.service;


public interface StudentService<T> extends Service<T> {
    void update(Long id, String firstName, String lastName);
}
