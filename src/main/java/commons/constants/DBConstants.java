package commons.constants;



/**
 * 
 * 
 *  TO do : This class needs to be converTED INTO ENUM 
 * 
 * 
 * @author I331862
 *
 */
public class DBConstants {

	// MOBILE_NUMBER NUMBER(12),EMAIL_ID VARCHAR2(100),NAME VARCHAR2(100))

	public static final class USER_DETAILS {

		public static String getName() {
			return "USER_DETAILS";
		}

		public final static String MOBILE_NUMBER = "MOBILE_NUMBER";
		public final static String EMAIL_ID = "EMAIL_ID";
		public final static String NAME = "NAME";
		public final static String PASSWORD = "PASSWORD";

	}

	public static final class ADDRESS {
		public static String getAddress() {
			return "ADDRESS";
		}

		public final static String MOBILE_NUMBER = "MOBILE_NUMBER";
		public final static String PLOT_NUMBER = "PLOT_NUMBER";
		public final static String AREA = "AREA";
		public final static String CITY = "CITY";
		public final static String PINCODE = "PINCODE";
		public final static String STATE = "STATE";

	}

}
