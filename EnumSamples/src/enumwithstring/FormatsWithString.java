/**
 * 
 */
package enumwithstring;

/**
 * @author bliu
 * 
 */
public enum FormatsWithString {
	JPEG("jpg"), PNG("png"), GIF("git");

	private String str;

	FormatsWithString(String str) {
		this.str = str;
	}
}
