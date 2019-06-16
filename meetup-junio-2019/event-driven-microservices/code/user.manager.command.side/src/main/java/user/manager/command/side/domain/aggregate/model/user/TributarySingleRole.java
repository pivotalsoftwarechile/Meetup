package user.manager.command.side.domain.aggregate.model.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=false)
public class TributarySingleRole extends SocialIdentifier {
	
	private final Integer rut;	
	private final Character digitIdentifier; 
	
	private static final String IDENTIFIER_FORMAT = "^[0-9]+-[0-9kK]{1}$";
	
	public TributarySingleRole(String tributarySingleRole) {
		assertIfValidIdentifier(tributarySingleRole);
		//
		this.rut = new Integer(extractRut(tributarySingleRole));
		this.digitIdentifier = new Character(extractDiguitIdentifier(tributarySingleRole));		
	}

	@Override
	protected void assertIfValidIdentifier(String tributarySingleRole) {
		try {
			if(!isValidFormat(tributarySingleRole)) {
				throw new IllegalArgumentException("National Single Role format not valid."); 
			}
			//
			Integer id = extractRut(tributarySingleRole);
			Character diguitIdentifier = extractDiguitIdentifier(tributarySingleRole);
			if(!isValidTributarySingleRole(id, diguitIdentifier)) {
				throw new IllegalArgumentException("National Single Role is not valid.");
			}
			
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("National Single Role format not valid.", e);
		}
		
	}	
	
	private Integer extractRut(String nationalUniqueRole) {
		Integer identifier;
		identifier = Integer.valueOf(nationalUniqueRole.split("-")[0]);
		
		return identifier;
	}
	
	private Character extractDiguitIdentifier(String nationalUniqueRole) {
		Character digit;
		digit = nationalUniqueRole.split("-")[1].charAt(0);
		
		return digit;
	}
	
	private boolean isValidFormat(String nationalUniqueRole) {
		boolean isValid = false;
		
		Pattern pattern = Pattern.compile(IDENTIFIER_FORMAT);
		Matcher matcher = pattern.matcher(nationalUniqueRole);
		if (matcher.matches()) { 
			isValid = true;
		}
		return isValid;
	}
	
	private boolean isValidTributarySingleRole(Integer id, Character diguitIdentifier) {
		int m = 0, s = 1;
		for (; id != 0; id /= 10) {
			s = (s + id % 10 * (9 - m++ % 6)) % 11;
		}
		return diguitIdentifier == (char) (s != 0 ? s + 47 : 75);
	}
	
	
	@Override	
	public String toString() {
		return String.format("%s-%s", rut, digitIdentifier);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {		
		return new TributarySingleRole(String.format("%s-%s", rut, digitIdentifier)) ;
	}

	@Override
	public String getIdentifier() {
		return String.format("%s-%s", rut, digitIdentifier);
	}
	
}
