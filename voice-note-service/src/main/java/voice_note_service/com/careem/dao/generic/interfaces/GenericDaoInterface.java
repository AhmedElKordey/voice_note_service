/**
 *
 */
package voice_note_service.com.careem.dao.generic.interfaces;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import voice_note_service.com.careem.dto.generic.EntitySelectionCriteriaDTO;

/**
 * @author AhmedTalaat
 *
 */
public interface GenericDaoInterface {

	void init();

	void close();

	<T> T getEntityById(Class<T> entityClass, Object id);

	<T> List<T> getEntityListByCriteria(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	<T> T getEntityByCriteria(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	<T> T persistEntity(T entity);

	<T> T mergeEntity(T entity);

	boolean deleteEntity(Object entity);

	<T> boolean deleteEntityById(Class<T> entityClass, Object id);

	EntityManager getEntityManager();

	<T> T getEntity(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	void setEntityManager(EntityManager entityManager);

	long executeCountQuery(String query);

	long executeCountQuery(EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	BigDecimal executeTotalQuery(EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	<T> T getTotalQuery(Class<T> entityClass, EntitySelectionCriteriaDTO entitySelectionCriteriaDto);

	<T> List<T> executeNativeSelectQuery(String nativeQuery, Class<T> returnTypeClass, int maxResults);

	void executeNativeUpdateQuery(String nativeQuery);
}
