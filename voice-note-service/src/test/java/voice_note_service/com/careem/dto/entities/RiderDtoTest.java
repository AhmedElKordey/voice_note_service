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
public class RiderDtoTest {
	private RiderDto rider = new RiderDto();

	@Test
	public final void email() {
		String email = "a.a@gmail.com";
		rider.setEmail(email);
		Assert.assertEquals(rider.getEmail(), email);
	}

	@Test
	public final void mobile() {
		String mobile = "010123456789";
		rider.setMobile(mobile);
		Assert.assertEquals(rider.getMobile(), mobile);
	}

	@Test
	public final void name() {
		String name = "Ahmed";
		rider.setName(name);
		Assert.assertEquals(rider.getName(), name);
	}

	@Test
	public final void id() {
		int id = 0;
		rider.setId(id);
		Assert.assertEquals(rider.getId(), Integer.valueOf(id));
	}
}
