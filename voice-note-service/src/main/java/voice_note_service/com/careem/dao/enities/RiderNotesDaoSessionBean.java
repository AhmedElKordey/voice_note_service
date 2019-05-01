/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import java.util.List;

import voice_note_service.com.careem.dao.enities.interfaces.RiderNotesDaoSessionBeanInterface;
import voice_note_service.com.careem.dao.generic.GenericDao;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;

/**
 * @author AhmedTalaat
 *
 */
public class RiderNotesDaoSessionBean extends GenericDao implements RiderNotesDaoSessionBeanInterface {

	@Override
	public long getNoteCountsStatusForTrip(int tripId, int statusCode, int noteId) {
		long count = 0;

		init();
		count = (long) entityManager.createNamedQuery(RiderNotesDto.NAMED_QUERY_GET_COUNT_OF_EACH_NOTE_STATUS)
				.setParameter(JPAConstants.TRIP_ID, tripId).setParameter(JPAConstants.NOTE_STAATUS, statusCode)
				.setParameter(JPAConstants.NOTE_ID, noteId).getSingleResult();
		close();
		return count;
	}

	@Override
	public void addRiderNotes(int noteId, int tripId, List<RiderTripsDto> riderTrips) {
		init();
		riderTrips.forEach(riderTrip -> {
			RiderNotesDto riderNote = new RiderNotesDto();
			riderNote.setNoteId(noteId);
			riderNote.setRiderTripID(riderTrip.getId());
			riderNote.setTripId(tripId);
			riderNote.setNoteStatus(JPAConstants.SENT);
			persistEntity(riderNote);
		});
		close();
	}

}
