package interfaces;

public interface Cypherable {

	/**
	 * Returns the technique name that is being implemented
	 * @return the name
	 */
	public String getCypherName();
	
	/**
	 * Encrypts the source string
	 * @param source the string that will be encrypted
	 * @return the encrypted string
	 */
	public String encrypt(String source);
	
	/**
	 * Decrypts the source string
	 * @param source the string that will be decrypted
	 * @return the decrypted string
	 */
	public String decrypt(String source);
	
}
