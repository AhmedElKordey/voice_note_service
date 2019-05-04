/**
 *
 */
package voice_note_service.com.careem.dto.entities;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author AhmedTalaat
 *
 */
public class RiderNotesDtoTest {

	private RiderNotesDto riderNotes = new RiderNotesDto();

	@Test
	public final void id() {
		int id = 1;
		riderNotes.setId(id);
		Assert.assertEquals(riderNotes.getId(), Integer.valueOf(id));
	}

	@Test
	public final void riderTripID() {
		int riderTripID = 1;
		riderNotes.setRiderTripID(riderTripID);
		Assert.assertEquals(riderNotes.getRiderTripID(), Integer.valueOf(riderTripID));
	}

	@Test
	public final void noteId() {
		int noteId = 1;
		riderNotes.setNoteId(noteId);
		Assert.assertEquals(riderNotes.getNoteId(), Integer.valueOf(noteId));
	}

	@Test
	public final void noteStatus() {
		int noteStatus = 1;
		riderNotes.setNoteStatus(noteStatus);
		Assert.assertEquals(riderNotes.getNoteStatus(), Integer.valueOf(noteStatus));
	}

	@Test
	public final void tripId() {
		int tripId = 1;
		riderNotes.setTripId(tripId);
		Assert.assertEquals(riderNotes.getTripId(), Integer.valueOf(tripId));
	}
}
