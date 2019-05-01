/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import java.util.ArrayList;
import java.util.List;

import voice_note_service.com.careem.dao.enities.interfaces.TripDaoSessionBeanInterface;
import voice_note_service.com.careem.dao.generic.GenericDao;
import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
public class TripDaoSessionBean extends GenericDao implements TripDaoSessionBeanInterface {

	@Override
	public List<TripDto> getAllTrips() {
		List<TripDto> trips = new ArrayList<>();
		try {
			init();
			trips.addAll(
					entityManager.createNamedQuery(TripDto.NANED_QUERY_GET_ALL_TRIPS, TripDto.class).getResultList());
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trips;
	}

}
