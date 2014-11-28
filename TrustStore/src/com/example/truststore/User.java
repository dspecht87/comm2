package com.example.truststore;

public class User {
	private long id;
	private String lookup_key;
	private String name;
	private int trust_level;
	
	public User(long id, String lookup_key, String name, int trust_level) {
		super();
		this.id = id;
		this.lookup_key = lookup_key;
		this.name = name;
		this.trust_level = trust_level;
	}
	
	public int getTrust_level() {
		return trust_level;
	}
	public void setTrust_level(int trust_level) {
		this.trust_level = trust_level;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getLookup_key() {
		return lookup_key;
	}
	public void setLookup_key(String lookup_key) {
		this.lookup_key = lookup_key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
