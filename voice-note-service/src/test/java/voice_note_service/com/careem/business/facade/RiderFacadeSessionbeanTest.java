/**
 *
 */
package voice_note_service.com.careem.business.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import voice_note_service.com.careem.dto.constants.JPAConstants;
import voice_note_service.com.careem.init.InitDtos;

/**
 * @author AhmedTalaat
 *
 */
public class RiderFacadeSessionbeanTest extends InitDtos {
	private RiderFacadeSessionbean riderFacade = new RiderFacadeSessionbean();

	@Before
	@Test
	public final void joinTrip() {
		int riderId = 3;
		int tripId = 1;
		Assert.assertEquals(riderFacade.joinTrip(tripId, riderId), JPAConstants.CONFIRMATION_MSG);
	}

	@Test
	public final void getAllAvalibleTrips() {
		int riderId = 1;
		Assert.assertNotEquals(riderFacade.getAllAvalibleTrips(riderId).size(), 0);
	}

	@Test
	public final void getAllUnReadedNotes() {
		int riderTripId = 3;
		Assert.assertNotEquals(riderFacade.getAllUnReadedNotes(riderTripId).size(), 0);
	}

	@Test
	public final void readNote() {
		int noteId = 1;
		int tripId = 1;
		int riderId = 3;
		Assert.assertNotEquals(riderFacade.readNote(noteId, tripId, riderId).getId(), Integer.valueOf(0));
	}

}
