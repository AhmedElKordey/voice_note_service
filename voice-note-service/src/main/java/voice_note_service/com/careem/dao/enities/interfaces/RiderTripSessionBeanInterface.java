/**
 *
 */
package voice_note_service.com.careem.dao.enities.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.RiderTripsDto;

/**
 * @author AhmedTalaat
 *
 */
public interface RiderTripSessionBeanInterface {
	List<RiderTripsDto> getAllRiderForSpecificTrip(int tripId);

	List<RiderTripsDto> getAllRiderForSpecificRider(int riderId);

	RiderTripsDto addRiderTrip(int riderId, int tripId);

	RiderTripsDto getRiderTrip(int riderId, int tripId);
}
