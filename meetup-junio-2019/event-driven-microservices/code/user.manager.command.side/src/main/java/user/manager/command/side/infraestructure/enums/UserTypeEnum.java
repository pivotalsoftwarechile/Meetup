package user.manager.command.side.infraestructure.enums;

import java.util.HashMap;

public enum UserTypeEnum {
	
	PERSON("PERSON", "Person"),
	PARTY_GROUP("PARTY_GROUP", "Party Group");
	

    private final String typeId;
    private final String description; 

	private UserTypeEnum(String typeId, String description) {
		this.typeId = typeId;
		this.description = description;
	}
	
    public String getTypeId() {
		return typeId;
	}

	public String getDescription() {
		return description;
	}


	public static HashMap<String, String> getHashMapValues() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (UserTypeEnum e : UserTypeEnum.values()) {
            hashMap.put(e.getTypeId(), e.getDescription());
        }
        return hashMap;
    }

}
