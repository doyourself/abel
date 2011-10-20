package com.xx.abel.dao.intf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.xx.abel.util.PageListData;


/**
 * 
 * @author Alen
 * @date 2011-5-25 下午02:01:32
 */
public interface BaseDAO<T,PK> {
	
	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void save(T entity);
	
	/**
	 * 删除实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void delete(T entity);
	
	/**
	 * 根据ID删除实体
	 * @param entityClass
	 * @param id
	 */
	public void deleteById(Class<T> entityClass, PK id);
	
	/**
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity);
	
	/**
	 * 查询实体集合�?
	 * @param entityClass
	 * @return
	 */
	public List<T> findAll(Class<T> entityClass);
	
	
	public PageListData findList(Class<T> entityClass, String hql, Object[] params, int currentPage, int pageSize);
	
	
	public List<T> findByProperty(Class<T> entityClass, String propertyName, Object value,int type);
	
	/**
	 * 根据ID查询实体
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T findById(Class<T> entityClass, PK id);
	
	public void proAdv( T entity ); 
	
	
	public Object loadObject(Class clazz, Serializable id);
	
	/**
	 * 带有参数查询，获取�?�的记录�?
	 * 
	 * @param hql
	 *            查询语句
	 * @param parms
	 *            查询参数
	 * @return 记录�?
	 */
	public long getRecordsCount(String hql, Object... parms) ;
	
	/**
	 * 查询结果是一个对�?.
	 * 
	 * @param hsql
	 *            查询语句
	 * @param parms
	 *            查询参数
	 * @return 单个字符�?
	 */
	public Object getFirstResult(String hsql, Object... parms);
	
	/**
	 * 查询结果是一个字符串.
	 * 
	 * @param hql
	 *            查询语句
	 * @param parms
	 *            查询参数
	 * @return 单个字符�?
	 */
	public Iterator getIteratorObjs(String hql, Object... parms);
	
	public List<T> getListAll(String hql, Object... parms);
	
	/**
	 * sql语句批量更新，效率更�?
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	public int bulkUpdate(String queryString, Object... values);
	

	
	public List<T> getJdbcList(String sql, Object... params);
	
	
}
