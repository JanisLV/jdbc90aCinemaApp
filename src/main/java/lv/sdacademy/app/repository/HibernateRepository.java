package lv.sdacademy.app.repository;

import java.util.List;

public interface HibernateRepository<R, ID> {
    void create(R domain);
    void update(R domain);
    List<R> findAll(Class<R> clazz);
    R findById(Class<R> clazz, ID id);
    void delete(R domain);
}
