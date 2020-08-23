package lv.sdacademy.app.repository;


import lv.sdacademy.app.utils.HibernateUtils;

import java.util.List;

public class AbstractHibernateRepository<R, ID> implements HibernateRepository<R, ID>{
    @Override
    public void create(R domain) {
        HibernateUtils.doInTransaction(session -> {
            session.save(domain);
        });
    }

    @Override
    public void update(R domain) {
        HibernateUtils.doInTransaction(session -> {
            session.update(domain);
        });
    }

    @Override
    public List<R> findAll(Class<R> clazz) {
        return HibernateUtils.doInTransactionWithResult(session -> {
            String simpleName = clazz.getSimpleName();
            return session.createQuery("from " + simpleName, clazz).list();
        });
    }

    @Override
    public R findById(Class<R> clazz, ID id) {
       return HibernateUtils.doInTransactionWithResult(session -> {
            return session.find(clazz, id);
        });
    }


    @Override
    public void delete(R domain) {
        HibernateUtils.doInTransaction(session -> {
            session.delete(domain);
        });
    }
}
