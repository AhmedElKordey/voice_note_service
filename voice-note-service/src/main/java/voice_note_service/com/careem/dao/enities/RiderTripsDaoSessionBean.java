/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import java.util.ArrayList;
import java.util.List;

import voice_note_service.com.careem.dao.enities.interfaces.RiderTripSessionBeanInterface;
import voice_note_service.com.careem.dao.generic.GenericDao;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;

/**
 * @author AhmedTalaat
 *
 */
public class RiderTripsDaoSessionBean extends GenericDao implements RiderTripSessionBeanInterface {

	@Override
	public List<RiderTripsDto> getAllRiderForSpecificTrip(int tripId) {
		List<RiderTripsDto> riderTrips = new ArrayList<>();

		init();
		riderTrips.addAll(
				entityManager.createNamedQuery(RiderTripsDto.NAMED_QUERY_GET_ALL_RIDER_TRIPS, RiderTripsDto.class)
						.setParameter(JPAConstants.TRIP_ID, tripId).getResultList());
		close();

		return riderTrips;
	}
}
