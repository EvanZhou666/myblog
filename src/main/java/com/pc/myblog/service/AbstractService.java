package com.pc.myblog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author zhouzixiang
 * @Date 2019/2/20 10:32
 **/
public abstract class AbstractService<T,S extends JpaRepository<T,Integer>> {
    protected S jpaRepository;

    public AbstractService (){}

    public AbstractService (S jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<T> findAll(){
        return jpaRepository.findAll();
    }

	public List<T> findAll(Iterable<Integer> ids){
	    return jpaRepository.findAll(ids);
	}

    public List<T> save(Iterable<T> entities){
        return jpaRepository.save(entities);
    }

    public T save(T entity) {
        return jpaRepository.saveAndFlush(entity);
    }
    public 	void deleteInBatch(Iterable<T> entities){
	    jpaRepository.deleteInBatch(entities);
    }

	public  void deleteAllInBatch(){
	    jpaRepository.deleteAllInBatch();
    }

	public T getOne(Integer id){
        return jpaRepository.getOne(id);
    }

    public Page<T> page (Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }
}
