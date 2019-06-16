package user.manager.command.side.domain.aggregate.model.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class NationalSingleRoleTest {

	@Test
	public void testOK() {
		NationalSingleRole nationalUniqueRole = new NationalSingleRole("15092027-2");
		
		assertNotNull(nationalUniqueRole.getIdentifier().equals(15092027));
		assertNotNull(nationalUniqueRole.getDigitIdentifier().equals('2'));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException1() {
		new NationalSingleRole("15092027-D");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException2() {
		new NationalSingleRole("1509202K-2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException3() {
		new NationalSingleRole("150920272");
	}
	
	@Test
	public void testToString() {
		NationalSingleRole nationalUniqueRole = new NationalSingleRole("15092027-2");
		
		assertNotNull(nationalUniqueRole.toString().equals("15092027-2"));			
	}
	
	@Test
	public void testClone() throws CloneNotSupportedException {
		NationalSingleRole nationalUniqueRole1 = new NationalSingleRole("15092027-2");
		NationalSingleRole nationalUniqueRole2 = (NationalSingleRole) nationalUniqueRole1.clone();
		
		assertNotNull(nationalUniqueRole2.toString().equals("15092027-2"));		
	}

}
