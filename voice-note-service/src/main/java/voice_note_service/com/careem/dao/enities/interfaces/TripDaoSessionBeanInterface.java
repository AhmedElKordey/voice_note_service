/**
 *
 */
package voice_note_service.com.careem.dao.enities.interfaces;

import java.util.List;

import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
public interface TripDaoSessionBeanInterface {
	List<TripDto> getAllTrips();
}
