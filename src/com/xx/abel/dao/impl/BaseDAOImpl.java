package com.xx.abel.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xx.abel.util.PageListData;
import com.xx.abel.dao.intf.BaseDAO;


/**
 * DAO层封装使用了泛型，包含常用的CURD和分页操�?
 * 
 * @author Alen
 * @date 2011-5-26 下午02:40:48
 */
public class BaseDAOImpl<T, PK extends Serializable> extends
		HibernateDaoSupport  implements BaseDAO<T, PK> {
	Logger logger =Logger.getLogger(BaseDAOImpl.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Autowired(required = true)
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(T entity) {
		try {
			getHibernateTemplate().save(entity);
			
		} catch (RuntimeException re) {
		}
	}

	public void saveOrUpdate(T entity) {
		try {
			getHibernateTemplate().merge(entity);
		} catch (Exception re) {
			System.out.println(re.getMessage());
		}
	}

	public void delete(T entity) {
		try {
			getHibernateTemplate().delete(entity);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void deleteById(Class<T> entityClass, PK id) {
		try {
			getHibernateTemplate().delete(findById(entityClass, id));
		} catch (Exception re) {
			logger.error("deleteById " + entityClass.getName() + " failed :{}",
					re);
		}
	}

	@SuppressWarnings("unchecked")
	public T findById(Class<T> entityClass, PK id) {
		try {
			return (T) getHibernateTemplate().load(entityClass, id);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClass) {
		try {
			return getHibernateTemplate().loadAll(entityClass);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value, int type) {
		String queryString = "";
		try {
			if (type == 1) {
				queryString = "from " + entityClass.getName()
						+ " as model where model." + propertyName + "= ?";
			} else if (type == 2) {
				queryString = "from " + entityClass.getName()
						+ " as model where model." + propertyName + "like ?";
			}
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public PageListData findList(Class<T> entityClass, String hql,
			Object[] params, int currentPage, int pageSize) {
		PageListData listdata = null;
		try {
			Query query = getSession().createQuery(getCountsHql(hql));
			if (null != params && 0 != params.length) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			} else {
				logger.warn(".");
			}
			
			int total = Integer.parseInt(query.uniqueResult()+"") ;
			logger.debug("查询count"+total);
			query = getSession().createQuery(hql);
			if (null != params && 0 != params.length) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			if (0 != pageSize) {
				query.setFirstResult(
						(currentPage == 0 ? 0 : currentPage - 1) * pageSize)
						.setMaxResults(pageSize);
			}
			List data = query.list();
			listdata = new PageListData(total, pageSize, currentPage, data);
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
		return listdata;
	}

	private String getCountsHql(String hql) {
		int index = hql.indexOf("from");
		if (index != -1) {
			return "select count(*) " + hql.substring(index);
		}
		throw new RuntimeException("sql====" + hql);
	}

	public void proAdv(T entity) {
		Session session = this.getSession();
		FlushMode flushMode=session.getFlushMode();
		session.setFlushMode(FlushMode.AUTO);

		Transaction tx= session.beginTransaction();    
		tx.begin();
		super.getHibernateTemplate().save(entity);
		tx.commit();
		session.flush();
		session.setFlushMode(flushMode);
		session.close();
		
	}

	public int bulkUpdate(String queryString, Object... values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}



	@SuppressWarnings("unchecked")
	public Object getFirstResult(String hsql, Object... parms) {

		Iterator it = getIteratorObjs(hsql, parms);
		if (it.hasNext()) {
			Object o = it.next();
			return o;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Iterator getIteratorObjs(String hql, Object... parms) {
		Iterator it = getHibernateTemplate().iterate(hql, parms);
		return it;
	}

	@SuppressWarnings("unchecked")
	public List getJdbcList(String sql, Object... params) {
		Query query = getSession().createSQLQuery(sql);		 
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List getListAll(String hql, Object... parms) {
		return (List) getHibernateTemplate().find(hql, parms);
	}


	public long getRecordsCount(String hql, Object... parms) {
		Query queryCount = getSession().createQuery("select count(*) " + hql);
		if (parms != null) {
			for (int i = 0; i < parms.length; i++) {
				queryCount.setParameter(i, parms[i]);
			}
		}
		long totalRecords = -1;
		Object count = queryCount.iterate().next();
		if (count != null) {
			totalRecords = ((Long) count).longValue();
		}
		return totalRecords;
	}

	@SuppressWarnings("unchecked")
	public Object loadObject(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

}
