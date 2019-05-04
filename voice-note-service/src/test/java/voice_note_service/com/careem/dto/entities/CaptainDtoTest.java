package voice_note_service.com.careem.dto.entities;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author AhmedTalaat
 *
 */
public class CaptainDtoTest {
	private CaptainDto captain = new CaptainDto();

	@Test
	public final void email() {
		String email = "a.a@gmail.com";
		captain.setEmail(email);
		Assert.assertEquals(captain.getEmail(), email);
	}

	@Test
	public final void mobile() {
		String mobile = "010123456789";
		captain.setMobile(mobile);
		Assert.assertEquals(captain.getMobile(), mobile);
	}

	@Test
	public final void name() {
		String name = "Ahmed";
		captain.setName(name);
		Assert.assertEquals(captain.getName(), name);
	}

	@Test
	public final void id() {
		int id = 0;
		captain.setId(id);
		Assert.assertEquals(captain.getId(), Integer.valueOf(id));
	}
}
