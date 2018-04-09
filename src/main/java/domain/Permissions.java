package domain;

public enum Permissions {
	NORMAL("normal"),
	PREMIUM("premium"), 
	ADMIN("admin");
	private final String value;
	private Permissions(String permission) {
		value = permission;
	}
	public String getValue() {
		return value;
	}
}
