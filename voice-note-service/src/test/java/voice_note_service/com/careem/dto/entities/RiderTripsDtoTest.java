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
public class RiderTripsDtoTest {
	private RiderTripsDto riderTrip = new RiderTripsDto();

	@Test
	public final void id() {
		int id = 1;
		riderTrip.setId(id);
		Assert.assertEquals(riderTrip.getId(), Integer.valueOf(id));
	}

	@Test
	public final void riderId() {
		int riderId = 1;
		riderTrip.setRiderId(riderId);
		Assert.assertEquals(riderTrip.getRiderId(), Integer.valueOf(riderId));
	}

	@Test
	public final void tripId() {
		int tripId = 1;
		riderTrip.setTripId(tripId);
		Assert.assertEquals(riderTrip.getTripId(), Integer.valueOf(tripId));
	}
}
