/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import java.util.ArrayList;
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
		try {
			init();
			count = (long) entityManager.createNamedQuery(RiderNotesDto.NAMED_QUERY_GET_COUNT_OF_EACH_NOTE_STATUS)
					.setParameter(JPAConstants.TRIP_ID, tripId).setParameter(JPAConstants.NOTE_STAATUS, statusCode)
					.setParameter(JPAConstants.NOTE_ID, noteId).getSingleResult();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void addRiderNotes(int noteId, int tripId, List<RiderTripsDto> riderTrips) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public RiderNotesDto addRiderNote(RiderNotesDto riderNote) {
		RiderNotesDto persistedRiderNote = new RiderNotesDto();
		try {
			init();
			persistedRiderNote = persistEntity(riderNote);
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persistedRiderNote;
	}

	@Override
	public List<RiderNotesDto> getAllUnReadedNotesForRiderTrip(int riderTripId) {
		List<RiderNotesDto> unreadedNotes = new ArrayList<>();
		try {
			init();
			unreadedNotes.addAll(entityManager
					.createNamedQuery(RiderNotesDto.NAMED_QUERY_GET_ALL_UNREADED_NOTES_FOR_REIDER, RiderNotesDto.class)
					.setParameter(JPAConstants.RIDER_TRIP_ID, riderTripId).getResultList());
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unreadedNotes;
	}

	@Override
	public RiderNotesDto updateStatusOfNotes(RiderNotesDto riderNote, int status) {
		RiderNotesDto mergedNote = new RiderNotesDto();
		try {
			init();
			riderNote.setNoteStatus(status);
			mergedNote = mergeEntity(riderNote);
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mergedNote;
	}

	@Override
	public RiderNotesDto getRiderNoteById(int riderNoteId) {
		RiderNotesDto riderNote = new RiderNotesDto();
		try {
			init();
			riderNote = entityManager
					.createNamedQuery(RiderNotesDto.NAMED_QUERY_GET_RIDER_NOTE_BY_ID, RiderNotesDto.class)
					.setParameter(JPAConstants.RIDER_NOTE_ID, riderNoteId).getSingleResult();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return riderNote;
	}

	@Override
	public RiderNotesDto getRiderNoteByRiderTripNoteIds(int noteId, int tripId, int riderTripId) {
		RiderNotesDto riderNote = new RiderNotesDto();
		try {
			init();
			riderNote = entityManager
					.createNamedQuery(RiderNotesDto.NAMED_QUERY_GET_RIDER_NOTE_BY_NOTE_TRIP_RIDER_IDS,
							RiderNotesDto.class)
					.setParameter(JPAConstants.NOTE_ID, noteId).setParameter(JPAConstants.TRIP_ID, tripId)
					.setParameter(JPAConstants.RIDER_TRIP_ID, riderTripId).getSingleResult();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return riderNote;
	}

}
