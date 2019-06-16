package user.manager.command.side.infraestructure.enums;

import java.util.HashMap;

public enum PartyStatusEnum {

	ENABLED("ENABLED", "Enabled"),
	DISABLED("DISABLED", "Disabled");


    private final String partyStatusId;
    private final String description;

	private PartyStatusEnum(String partyStatusId, String description) {
		this.partyStatusId = partyStatusId;
		this.description = description;
	}


    public String getPartyStatusId() {
		return partyStatusId;
	}


	public String getDescription() {
		return description;
	}


	public static HashMap<String, String> getHashMapValues() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (PartyStatusEnum e : PartyStatusEnum.values()) {
            hashMap.put(e.getPartyStatusId(), e.getDescription());
        }
        return hashMap;
    }

}
