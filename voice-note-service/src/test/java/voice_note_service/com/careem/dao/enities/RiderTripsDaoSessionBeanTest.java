/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author AhmedTalaat
 *
 */
public class RiderTripsDaoSessionBeanTest {
	RiderTripsDaoSessionBean tripDao = new RiderTripsDaoSessionBean();

	@Test
	public final void getAllRiderForSpecificTrip() {
		Assert.assertNotEquals(tripDao.getAllRiderForSpecificRider(1).size(), 0);
	}

	@Test
	public final void getAllRiderTripsForSpecificRider() {
		Assert.assertNotEquals(tripDao.getAllRiderForSpecificRider(1).size(), 0);
	}

	@Test
	public final void addRiderTrip() {
		int riderId = 3;
		int tripId = 2;

		Assert.assertNotEquals(tripDao.addRiderTrip(riderId, tripId).getId(), Integer.valueOf(0));
		Assert.assertNotNull(tripDao.addRiderTrip(riderId, tripId).getId());
	}

	@Test
	public final void getRiderTrip() {
		int riderId = 1;
		int tripId = 1;

		Assert.assertNotEquals(tripDao.getRiderTrip(riderId, tripId).getId(), Integer.valueOf(0));
		Assert.assertNotNull(tripDao.getRiderTrip(riderId, tripId).getId());
	}
}
