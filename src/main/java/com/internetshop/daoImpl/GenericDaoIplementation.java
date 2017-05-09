package com.internetshop.daoImpl;


	import java.lang.reflect.ParameterizedType;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.NoResultException;
	import javax.persistence.NonUniqueResultException;
	import javax.persistence.Persistence;
	import javax.persistence.PersistenceContext;
	import javax.persistence.PersistenceUnit;

	import com.internetshop.dao.GenericDao;


	public class GenericDaoIplementation<T, K> implements GenericDao<T, K>
	{
		protected Class<T> entityClass;
		@PersistenceUnit
		private EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		
		@PersistenceContext
		private EntityManager entityManager = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		public GenericDaoIplementation() 
		{
			ParameterizedType genericSuperclass = (ParameterizedType) getClass()
		             .getGenericSuperclass();
		        this.entityClass = (Class<T>) genericSuperclass
		             .getActualTypeArguments()[0];
		}


		public EntityManager getEntityManager()
		{
			return entityManager;
		}

		public void setEntityManager(EntityManager entityManager) 
		{
			this.entityManager = entityManager;
		}

		public Class<T> getEntityClass()
		{
			return entityClass;
		}

		public void setEntityClass(Class<T> entityClass)
		{
			this.entityClass = entityClass;
		}

		public T add(T entity) 
		{
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			
			return entity;
		}

		public T update(T entity) 
		{
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		
			return entity;
		}

		public void delete(K fieldName, K fieldValue) 
		{
			T entity = getOne(fieldName, fieldValue);
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		
		}

		@SuppressWarnings("unchecked")
		public T getOne(K fieldName, K fieldValue) 
		{
			entityManager.getTransaction().begin();
			T entity = null;
			try
			{
				entity = (T) entityManager
						.createQuery("select u from " + entityClass.getSimpleName()+ " u where u." + fieldName + " =:value1")
						.setParameter("value1", fieldValue)
						.getSingleResult();
			}
			catch(NoResultException e)
			{
				System.out.println(e.getMessage());
			}
			catch(NonUniqueResultException e)
			{
				System.out.println(e.getMessage());
			}
			entityManager.getTransaction().commit();
			return entity;
		}

		@SuppressWarnings("unchecked")
		public List<T> getAll()
		{
			entityManager.getTransaction().begin();
			List<T> list = entityManager
					.createQuery("from " + entityClass.getName())
					.getResultList();
			entityManager.getTransaction().commit();
			
			return list;
		}
		void close(){
			entityManager.close();
			factory.close();
		}
	}
	
	
	



