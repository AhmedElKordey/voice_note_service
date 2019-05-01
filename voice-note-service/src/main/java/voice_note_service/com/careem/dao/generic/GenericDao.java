/**
 *
 */
package voice_note_service.com.careem.dao.generic;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import voice_note_service.com.careem.dao.generic.interfaces.GenericDaoInterface;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.generic.EntitySelectionCriteriaDTO;

/**
 * @author AhmedTalaat
 *
 */
public abstract class GenericDao implements GenericDaoInterface {

	protected EntityManagerFactory factory;
	protected EntityManager entityManager;

	@Override
	public void init() {
		factory = Persistence.createEntityManagerFactory(JPAConstants.PERSISTENT_UNIT_SERVICE_DAO);
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	@Override
	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	@Override
	public <T> T getEntityById(Class<T> entityClass, Object id) {
		try {
			return entityManager.find(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> List<T> getEntityListByCriteria(Class<T> entityClass,
			EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {

		try {
			TypedQuery<T> query = null;

			if (!entitySelectionCriteriaDto.getNamedQueryString().isEmpty()) {
				query = entityManager.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(), entityClass);
			}

			else if (!entitySelectionCriteriaDto.getQueryString().isEmpty()) {
				query = entityManager.createQuery(entitySelectionCriteriaDto.getQueryString(), entityClass);
			}

			if (query != null) {
				if (entitySelectionCriteriaDto.isHandlePagination()) {
					query.setFirstResult(entitySelectionCriteriaDto.getFirstResultIndex());
					query.setMaxResults(entitySelectionCriteriaDto.getMaxNumberOfResults());
				}

				if (entitySelectionCriteriaDto.getParamters() != null
						&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
					Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

					while (paramIterator.hasNext()) {
						String key = paramIterator.next();
						query.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
					}
				}

				List<T> result = query.getResultList();

				return result == null ? Collections.emptyList() : result;
			}

			else {
				return Collections.emptyList();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public <T> T getEntityByCriteria(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {
		try {
			TypedQuery<T> query = null;
			if (!(entitySelectionCriteriaDto.getNamedQueryString()).isEmpty()) {
				query = entityManager.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(), entityClass);
			}

			else if (!(entitySelectionCriteriaDto.getQueryString()).isEmpty()) {
				query = entityManager.createQuery(entitySelectionCriteriaDto.getQueryString(), entityClass);
			}

			if (query != null) {
				if (entitySelectionCriteriaDto.getParamters() != null
						&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
					Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

					while (paramIterator.hasNext()) {
						String key = paramIterator.next();
						query.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
					}
				}

				return query.getSingleResult();
			}

			else {
				return null;
			}
		}

		catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public <T> T persistEntity(T entity) {
		try {
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.refresh(entity);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public <T> T mergeEntity(T entity) {
		T mergedEntity = null;

		try {
			mergedEntity = entityManager.merge(entity);
			entityManager.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return mergedEntity;
	}

	@Override
	public boolean deleteEntity(Object entity) {
		try {
			entityManager.merge(entity);
			entityManager.remove(entity);
			entityManager.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public <T> boolean deleteEntityById(Class<T> entityClass, Object id) {
		try {
			entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id")
					.setParameter("id", id).executeUpdate();

			entityManager.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public <T> T getEntity(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {
		try {
			TypedQuery<T> query = null;

			if (!(entitySelectionCriteriaDto.getNamedQueryString()).isEmpty()) {
				query = entityManager.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(), entityClass);
			}

			else if (!(entitySelectionCriteriaDto.getQueryString()).isEmpty()) {
				query = entityManager.createQuery(entitySelectionCriteriaDto.getQueryString(), entityClass);
			}

			if (query != null) {
				query.setMaxResults(1);

				if (entitySelectionCriteriaDto.getParamters() != null
						&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
					Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

					while (paramIterator.hasNext()) {
						String key = paramIterator.next();
						query.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
					}
				}

				return query.getSingleResult();
			}

			else {
				return null;
			}
		}

		catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public long executeCountQuery(String query) {
		try {
			TypedQuery<Long> typedQuery = entityManager.createQuery(query, Long.class);
			return typedQuery.getSingleResult();
		}

		catch (NoResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}

	@Override
	public long executeCountQuery(EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {
		try {
			TypedQuery<Long> typedQuery = entityManager
					.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(), Long.class);

			if (entitySelectionCriteriaDto.getParamters() != null
					&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
				Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

				while (paramIterator.hasNext()) {
					String key = paramIterator.next();
					typedQuery.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
				}
			}

			return typedQuery.getSingleResult();
		}

		catch (NoResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}

	@Override
	public BigDecimal executeTotalQuery(EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {
		try {
			TypedQuery<BigDecimal> typedQuery = entityManager
					.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(), BigDecimal.class);

			if (entitySelectionCriteriaDto.getParamters() != null
					&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
				Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

				while (paramIterator.hasNext()) {
					String key = paramIterator.next();
					typedQuery.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
				}
			}

			BigDecimal total = typedQuery.getSingleResult();

			if (total == null) {
				total = BigDecimal.ZERO;
			}

			return total;
		}

		catch (NoResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return BigDecimal.ZERO;
	}

	@Override
	public <T> T getTotalQuery(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto) {
		try {
			TypedQuery<T> typedQuery = entityManager.createNamedQuery(entitySelectionCriteriaDto.getNamedQueryString(),
					entityClass);

			if (entitySelectionCriteriaDto.getParamters() != null
					&& !entitySelectionCriteriaDto.getParamters().isEmpty()) {
				Iterator<String> paramIterator = entitySelectionCriteriaDto.getParamters().keySet().iterator();

				while (paramIterator.hasNext()) {
					String key = paramIterator.next();
					typedQuery.setParameter(key, entitySelectionCriteriaDto.getParamters().get(key));
				}
			}

			return typedQuery.getSingleResult();
		}

		catch (NoResultException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> executeNativeSelectQuery(String nativeQuery, Class<T> returnTypeClass, int maxResults) {
		try {
			Query query = entityManager.createNativeQuery(nativeQuery, returnTypeClass);
			query.setMaxResults(maxResults);

			List<T> result = query.getResultList();

			if (result == null) {
				return Collections.emptyList();
			}

			else {
				return result;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void executeNativeUpdateQuery(String nativeUpdateQuery) {
		try {
			Query query = entityManager.createNativeQuery(nativeUpdateQuery);
			query.executeUpdate();

			entityManager.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
