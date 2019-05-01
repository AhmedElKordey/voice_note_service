package voice_note_service.com.careem.dto.constants;

/**
 * @author AhmedTalaat
 * @Description This Class will act as the centralized location that will
 *              contain all the application JPA related attributes as a set of
 *              constants
 */
public abstract class JPAConstants {
	private JPAConstants() {
	}

	// Persistence Units' Names
	public static final String PERSISTENT_UNIT_SERVICE_DAO = "ServiceDAO";

	// Schema Name
	public static final String SCHEMA_NAME = "[vsn]";

	// Tables' Names
	public static final String TABLE_NAME_CAPTAIN = "cap";
	public static final String TABLE_NAME_RIDER = "rider";
	public static final String TABLE_NAME_TRIP = "trip";
	public static final String TABLE_NAME_NOTES = "notes";
	public static final String TABLE_NAME_RIDER_NOTES = "rider_notes";
	public static final String TABLE_NAME_RIDER_TRIPS = "rider_trips";

	// Query parameters - columns
	public static final String TRIP_ID = "tripId";
	public static final String NOTE_STAATUS = "noteStatus";
	public static final String NOTE_ID = "noteId";

	// Note status codes
	public static final int SENT = 0;
	public static final int RECIVED = 1;
	public static final int READ = 2;

}
