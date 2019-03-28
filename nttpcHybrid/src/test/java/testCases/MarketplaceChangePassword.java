package testCases;

import org.testng.annotations.Test;

import customcommands.ActionsDriver;
import customcommands.PropertyReader;
import objectrepository.MarketplaceChangePasswordPage;
import objectrepository.MarketplaceProfilePage;
import objectrepository.UsernameDropdownPage;

public class MarketplaceChangePassword extends ActionsDriver {

	public PropertyReader pReader;//@Test(dependsOnGroups="Marketplace Login",groups="Smoke")
	@Test(priority=0,groups="SmokeTesting")
	
	//@Test
	public void changePassword() throws Exception{
		pReader=new PropertyReader();
		try{
		mouseHoverAndClick(UsernameDropdownPage.linkAccountHeader, UsernameDropdownPage.linkProfile,"MyAccountPage");
		click(MarketplaceProfilePage.linkChangePassword,"Change Password Tab");
		type(MarketplaceChangePasswordPage.txtCurrentPassword, pReader.getMarketplacePassword(),"Current Password");
		//type(MarketplaceChangePasswordPage.txtNewPassword, "87654321");
		//type(MarketplaceChangePasswordPage.txtConfirmPassword, "87654321");
		type(MarketplaceChangePasswordPage.txtNewPassword,generatePassword(),"New Password");
		type(MarketplaceChangePasswordPage.txtConfirmPassword,generatePassword(),"Confirm Password");
		click(MarketplaceChangePasswordPage.btnSubmit,"Submit button of Change Password");
		Thread.sleep(3000);
		mouseHoverAndClick(UsernameDropdownPage.linkAccountHeader, UsernameDropdownPage.linkLogOut,"Logout Link");
		log.info("Change Password is successful");
		}catch(Exception e){
			log.error("Change Password is unsuccessful and the error is "+e);
		}
	}
	@Test(groups="SmokeTesting")
	public void successMessage()
	{
		System.out.println("Test1");
	}
	@Test(groups="SmokeTesting")
	public void successMessage1()
	{
		System.out.println("Test2");
	}
	@Test(groups="RegressionTesting")
	public void successMessage11()
	{
		System.out.println("Test3");
	}

}
