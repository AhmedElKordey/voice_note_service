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
		try {
			init();
			riderTrips.addAll(entityManager
					.createNamedQuery(RiderTripsDto.NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_TRIP, RiderTripsDto.class)
					.setParameter(JPAConstants.TRIP_ID, tripId).getResultList());
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return riderTrips;
	}

	@Override
	public List<RiderTripsDto> getAllRiderForSpecificRider(int riderId) {
		List<RiderTripsDto> riderTrips = new ArrayList<>();
		try {
			init();
			riderTrips.addAll(entityManager
					.createNamedQuery(RiderTripsDto.NAMED_QUERY_GET_ALL_RIDER_TRIPS_PER_RIDER, RiderTripsDto.class)
					.setParameter(JPAConstants.RIDER_ID, riderId).getResultList());
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return riderTrips;
	}

	@Override
	public RiderTripsDto addRiderTrip(int riderId, int tripId) {
		RiderTripsDto riderTrip = new RiderTripsDto();
		riderTrip.setRiderId(riderId);
		riderTrip.setTripId(tripId);
		RiderTripsDto persistedRiderTrip = new RiderTripsDto();
		try {
			init();
			persistedRiderTrip = persistEntity(riderTrip);
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persistedRiderTrip;
	}
}
