/**
 *
 */
package voice_note_service.com.careem.business.facade;

import java.util.ArrayList;
import java.util.List;

import voice_note_service.com.careem.business.facade.interfaces.RiderFacadeSessionBeanInterface;
import voice_note_service.com.careem.dao.enities.NoteDaoSessionBean;
import voice_note_service.com.careem.dao.enities.RiderNotesDaoSessionBean;
import voice_note_service.com.careem.dao.enities.RiderTripsDaoSessionBean;
import voice_note_service.com.careem.dao.enities.TripDaoSessionBean;
import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.dto.entities.NoteDto;
import voice_note_service.com.careem.dto.entities.RiderNotesDto;
import voice_note_service.com.careem.dto.entities.RiderTripsDto;
import voice_note_service.com.careem.dto.entities.TripDto;

/**
 * @author AhmedTalaat
 *
 */
public class RiderFacadeSessionbean implements RiderFacadeSessionBeanInterface {

	private RiderTripsDaoSessionBean riderTripsDaoSessionBean = new RiderTripsDaoSessionBean();
	private TripDaoSessionBean tripDaoSessionBean = new TripDaoSessionBean();
	private NoteDaoSessionBean noteDaoSessionBean = new NoteDaoSessionBean();
	private RiderNotesDaoSessionBean riderNotesDaoSessionBean = new RiderNotesDaoSessionBean();

	@Override
	public List<TripDto> getAllAvalibleTrips(int riderId) {
		List<TripDto> trips = new ArrayList<>();

		// Get all trips joined by this rider
		List<RiderTripsDto> riderTrip = new ArrayList<>();
		riderTrip.addAll(riderTripsDaoSessionBean.getAllRiderForSpecificRider(riderId));

		// Get all trips
		List<TripDto> allTrips = new ArrayList<>();
		allTrips.addAll(tripDaoSessionBean.getAllTrips());

		// filter trips
		boolean found = false;
		for (int i = 0; i < allTrips.size(); i++) {
			found = false;
			for (int j = 0; j < riderTrip.size(); j++) {
				if (allTrips.get(i).getId() == riderTrip.get(j).getTripId()) {
					found = true;
					break;
				}
			}
			if (!found) {
				trips.add(allTrips.get(i));
			}
		}

		// Return trips
		return trips;
	}

	@Override
	public String joinTrip(int tripId, int riderId) {
		String joined = JPAConstants.CONFIRMATION_MSG;

		// add new row in rider_trip table
		RiderTripsDto riderTrip = new RiderTripsDto();
		riderTrip = riderTripsDaoSessionBean.addRiderTrip(riderId, tripId);

		// get all notifications related to this trip
		List<NoteDto> notes = new ArrayList<>();
		notes.addAll(noteDaoSessionBean.getNotesByTripId(tripId));

		// add those notifications to this rider
		for (int i = 0; i < notes.size(); i++) {
			RiderNotesDto riderNote = new RiderNotesDto();
			riderNote.setNoteId(notes.get(i).getId());
			riderNote.setNoteStatus(JPAConstants.SENT);
			riderNote.setRiderTripID(riderTrip.getId());
			riderNote.setTripId(notes.get(i).getTripId());
			riderNotesDaoSessionBean.addRiderNote(riderNote);
		}
		return joined;
	}

	@Override
	public List<NoteDto> getAllUnReadedNotes(int riderTripId) {
		List<NoteDto> unreadedNotes = new ArrayList<>();

		// 1- get all unreaded notes IDs
		List<RiderNotesDto> unreadedRiderNotes = new ArrayList<>();
		unreadedRiderNotes.addAll(riderNotesDaoSessionBean.getAllUnReadedNotesForRiderTrip(riderTripId));

		// 2- update notes to recived status
		for (int i = 0; i < unreadedRiderNotes.size(); i++) {
			riderNotesDaoSessionBean.updateStatusOfNotes(unreadedRiderNotes.get(i), JPAConstants.RECIVED);
		}

		// 3 get all notes details
		for (int i = 0; i < unreadedRiderNotes.size(); i++) {
			unreadedNotes.add(noteDaoSessionBean.getNoteById(unreadedRiderNotes.get(i).getNoteId()));
		}

		return unreadedNotes;
	}

	@Override
	public RiderNotesDto readNote(int riderNoteId) {
		return riderNotesDaoSessionBean.updateStatusOfNotes(riderNotesDaoSessionBean.getRiderNoteById(riderNoteId),
				JPAConstants.READ);
	}

}
