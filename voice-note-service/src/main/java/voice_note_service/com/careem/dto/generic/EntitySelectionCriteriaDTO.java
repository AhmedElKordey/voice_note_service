/**
 *
 */
package voice_note_service.com.careem.dto.generic;

import java.util.Map;

/**
 * @author AhmedTalaat
 *
 */
public class EntitySelectionCriteriaDTO extends GenericDTO {
	private static final long serialVersionUID = 158861829990530344L;

	private String namedQueryString;
	private String queryString;

	private boolean handlePagination = true;
	private int firstResultIndex = 0;
	private final int maxNumberOfResults = 100;

	private transient Map<String, Object> paramters;

	public EntitySelectionCriteriaDTO(String namedQueryString, boolean handlePagination) {
		this.namedQueryString = namedQueryString;
		this.handlePagination = handlePagination;
	}

	public EntitySelectionCriteriaDTO(String namedQueryString, boolean handlePagination,
			Map<String, Object> paramters) {
		this(namedQueryString, handlePagination);
		this.paramters = paramters;
	}

	public int getFirstResultIndex() {
		return firstResultIndex;
	}

	public String getNamedQueryString() {
		return namedQueryString;
	}

	public void setNamedQueryString(String namedQueryString) {
		this.namedQueryString = namedQueryString;
	}

	public boolean isHandlePagination() {
		return handlePagination;
	}

	public void setHandlePagination(boolean handlePagination) {
		this.handlePagination = handlePagination;
	}

	public void setFirstResultIndex(int firstResultIndex) {
		this.firstResultIndex = firstResultIndex;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}

	public Map<String, Object> getParamters() {
		return paramters;
	}

	public void setParamters(Map<String, Object> paramters) {
		this.paramters = paramters;
	}

	public int getMaxNumberOfResults() {
		return maxNumberOfResults;
	}
}