package qiao;

public class HashTable {
	private Object[][] m_objects;
	private static final int DEFAULT_BUCKET_COUNT = 10;
	private static final int DEFAULT_BUCKET_SIZE = 10;

	public HashTable() {
		m_objects = new Object[DEFAULT_BUCKET_COUNT][DEFAULT_BUCKET_SIZE];
		
	}

}
