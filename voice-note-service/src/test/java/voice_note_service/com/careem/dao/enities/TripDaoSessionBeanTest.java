/**
 *
 */
package voice_note_service.com.careem.dao.enities;

import org.junit.Assert;
import org.junit.Test;

import voice_note_service.com.careem.init.InitDtos;

/**
 * @author AhmedTalaat
 *
 */
public class TripDaoSessionBeanTest extends InitDtos {
	private TripDaoSessionBean tripDao = new TripDaoSessionBean();

	@Test
	public final void getAllTrips() {
		Assert.assertNotEquals(tripDao.getAllTrips().size(), 0);
	}
}
