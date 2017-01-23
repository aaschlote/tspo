package de.com.tspo.digest;

public class TestSha1 {
	
	public static void main(String[] args) {
		try {
			Sha1Digest sha1 = new Sha1Digest();
			
			System.out.println(sha1.SHA1("123"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
