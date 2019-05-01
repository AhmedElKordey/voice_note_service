package voice_note_service.com.careem.dto.generic;

import java.io.Serializable;

/**
 * @author AhmedTalaat
 * @Description This Class will act as a general DTO that all system DTOs must
 *              extend, such that when there is a need to apply any generic
 *              method or property on all system DTOs then this can be applied
 *              in only the parent class and all the child classes will have it
 *              automatically
 */

public abstract class GenericDTO implements Serializable {
	private static final long serialVersionUID = -5190207256548070447L;

	// Declarations

	/** Default Constructor */
	public GenericDTO() {
	}

	// Methods

	// Getters & Setters
}
