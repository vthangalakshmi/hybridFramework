package com.nttpc.marketplace.testcases;

import org.testng.annotations.Test;

import com.nttpc.marketplace.objectrepository.MarketplaceChangePasswordPage;
import com.nttpc.marketplace.objectrepository.MarketplaceProfilePage;
import com.nttpc.marketplace.objectrepository.UsernameDropdownPage;
import com.nttpc.utilities.ActionsDriver;

public class MarketplaceChangePassword extends ActionsDriver {

	//@Test(dependsOnGroups="Marketplace Login",groups="Smoke")
	@Test(priority=0,groups="SmokeTesting")
	public void changePassword() throws Exception{
		try{
		highLightElement(UsernameDropdownPage.linkAccountHeader,"accountHeader");
		mouseHoverAndClick(UsernameDropdownPage.linkAccountHeader, UsernameDropdownPage.linkProfile,"MyAccountPage");
		highLightElement(MarketplaceProfilePage.linkChangePassword,"changePassword");
		click(MarketplaceProfilePage.linkChangePassword,"Change Password Tab");
		type(MarketplaceChangePasswordPage.txtCurrentPassword,marketplacePasssword ,"Current Password");
		type(MarketplaceChangePasswordPage.txtNewPassword,generatePassword(),"New Password");
		type(MarketplaceChangePasswordPage.txtConfirmPassword,generatePassword(),"Confirm Password");
		highLightElement(MarketplaceChangePasswordPage.btnSubmit,"changePasswordSubmit");
		click(MarketplaceChangePasswordPage.btnSubmit,"Submit button of Change Password");
		Thread.sleep(3000);
		highLightElement(UsernameDropdownPage.linkAccountHeader,"logoutLink");
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
