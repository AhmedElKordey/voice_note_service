/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import org.junit.Assert;
import org.junit.Test;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.init.InitDtos;

/**
 * @author AhmedTalaat
 *
 */
public class RiderNotesDaoSessionBeanTest extends InitDtos {
	RiderNotesDaoSessionBean riderNoteDao = new RiderNotesDaoSessionBean();

	@Test
	public final void getNoteCountsStatusForTrip() {
		int tripId = 1;
		int statusCode = JPAConstants.SENT;
		int noteId = 1;

		Assert.assertNotEquals(riderNoteDao.getNoteCountsStatusForTrip(tripId, statusCode, noteId), 0);
	}

	@Test
	public final void addRiderNote() {
		Assert.assertNotEquals(riderNoteDao.addRiderNote(initRiderNotesDto()).getId(), Integer.valueOf(0));
	}

	@Test
	public final void getAllUnReadedNotesForRiderTrip() {
		int riderTripId = 3;
		Assert.assertNotEquals(riderNoteDao.getAllUnReadedNotesForRiderTrip(riderTripId).size(), 0);
	}

	@Test
	public final void getRiderNoteById() {
		int riderNoteId = 1;
		Assert.assertEquals(riderNoteDao.getRiderNoteById(riderNoteId).getId(), Integer.valueOf(riderNoteId));
	}

	@Test
	public final void getRiderNoteByRiderTripNoteIds() {
		int noteId = 1;
		int tripId = 1;
		int riderTripId = 1;
		Assert.assertNotEquals(riderNoteDao.getRiderNoteByRiderTripNoteIds(noteId, tripId, riderTripId).getId(),
				Integer.valueOf(0));
	}
}
