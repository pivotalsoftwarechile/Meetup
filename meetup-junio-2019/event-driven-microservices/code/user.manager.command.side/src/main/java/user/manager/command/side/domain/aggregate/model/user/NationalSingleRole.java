package user.manager.command.side.domain.aggregate.model.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=false)
public class NationalSingleRole extends SocialIdentifier {
	
	private final Integer run;	
	private final Character digitIdentifier; 
	
	private static final String IDENTIFIER_FORMAT = "^[0-9]+-[0-9kK]{1}$";
	
	public NationalSingleRole(String nationalSingleRole) {
		assertIfValidIdentifier(nationalSingleRole);
		//
		this.run = new Integer(extractRun(nationalSingleRole));
		this.digitIdentifier = new Character(extractDiguitIdentifier(nationalSingleRole));		
	}

	@Override
	protected void assertIfValidIdentifier(String nationalSingleRole) {
		try {
			if(!isValidFormat(nationalSingleRole)) {
				throw new IllegalArgumentException("National Single Role format not valid."); 
			}
			//
			Integer id = extractRun(nationalSingleRole);
			Character diguitIdentifier = extractDiguitIdentifier(nationalSingleRole);
			if(!isValidNationalSingleRole(id, diguitIdentifier)) {
				throw new IllegalArgumentException("National Single Role is not valid.");
			}
			
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("National Single Role format not valid.", e);
		}
		
	}	
	
	private Integer extractRun(String nationalUniqueRole) {
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
	
	private boolean isValidNationalSingleRole(Integer id, Character diguitIdentifier) {
		int m = 0, s = 1;
		for (; id != 0; id /= 10) {
			s = (s + id % 10 * (9 - m++ % 6)) % 11;
		}
		return diguitIdentifier == (char) (s != 0 ? s + 47 : 75);
	}
	
	
	@Override	
	public String toString() {
		return String.format("%s-%s", run, digitIdentifier);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {		
		return new NationalSingleRole(String.format("%s-%s", run, digitIdentifier)) ;
	}

	@Override
	public String getIdentifier() {
		return String.format("%s-%s", run, digitIdentifier);
	}
	
}
