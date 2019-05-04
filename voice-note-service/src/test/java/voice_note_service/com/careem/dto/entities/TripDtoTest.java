/**
 *
 */
package voice_note_service.com.careem.dto.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author AhmedTalaat
 *
 */
public class TripDtoTest {
	private TripDto trip = new TripDto();

	@Test
	public final void id() {
		int id = 1;
		trip.setId(id);
		Assert.assertEquals(trip.getId(), Integer.valueOf(id));
	}

	@Test
	public final void fromPlace() {
		String fromPlace = "Palce A";
		trip.setFromPlace(fromPlace);
		Assert.assertEquals(trip.getFromPlace(), fromPlace);
	}

	@Test
	public final void toPlace() {
		String toPlace = "Palce A";
		trip.setToPlace(toPlace);
		Assert.assertEquals(trip.getToPlace(), toPlace);
	}

	@Test
	public final void FromTime() throws ParseException {
		Date fromTime = new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2019");
		trip.setFromTime(fromTime);
		Assert.assertEquals(trip.getFromTime(), fromTime);
	}

	@Test
	public final void toTime() throws ParseException {
		Date toTime = new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2019");
		trip.setToTime(toTime);
		Assert.assertEquals(trip.getToTime(), toTime);
	}

	@Test
	public final void capId() {
		int capId = 1;
		trip.setCapId(capId);
		Assert.assertEquals(trip.getCapId(), Integer.valueOf(capId));
	}

}
