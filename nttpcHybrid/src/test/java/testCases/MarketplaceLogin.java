package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import customcommands.ActionsDriver;
import customcommands.PropertyReader;
import objectrepository.MarketplaceHomePage;
import objectrepository.MarketplaceLoginPage;
import objectrepository.UsernameDropdownPage;

public class MarketplaceLogin extends ActionsDriver {
	
	public PropertyReader pReader;
	
	@Test(groups={"SmokeTesting"})
	public void openingLoginPage() throws Exception{
		try{
			pReader=new PropertyReader();
			exTest.log(Status.INFO, "Launch the application");
			launchApplication(pReader.getMarketplaceUrl());
			Thread.sleep(3000);
			exTest.log(Status.INFO, "Go to the login page");
			highLightElement(MarketplaceHomePage.linkAccount,"accountHeader");
			mouseHoverAndClick(MarketplaceHomePage.linkAccount,MarketplaceHomePage.linkLogin,"LoginLink");
			
			}catch(Exception e){
			Thread.sleep(10000);
			log.error("Unable to open login page "+e);
	       }			
	}	
	@Test(dependsOnMethods="openingLoginPage",groups={"SmokeTesting"},alwaysRun=true)
	public void loginSuccess() throws Exception{
		try{
			exTest.log(Status.INFO, "Login to the application");
			type(MarketplaceLoginPage.mailid, pReader.getMarketplaceEmailid(),"EmailID");
			type(MarketplaceLoginPage.password, pReader.getMarketplacePassword(),"Password");
			highLightElement(MarketplaceLoginPage.btnSignin,"loginButton");
			click(MarketplaceLoginPage.btnSignin,"Login Button");
			Thread.sleep(1000);
			log.info("Login is successful");
		}catch(Exception e){
			log.error("Login is unsuccessful and the error is "+e);
		}
		}
	@Test(priority=2)
	public void logOut() throws Exception{
		try{
			exTest.log(Status.INFO, "Logout from the application");
			highLightElement(UsernameDropdownPage.linkAccountHeader,"logoutLink");
			mouseHoverAndClick(UsernameDropdownPage.linkAccountHeader, UsernameDropdownPage.linkLogOut,"Logout Link");
			Thread.sleep(1000);
			Assert.assertEquals("Test1", "Test2ewe");
			log.info("Logout is successful");
		}catch(Exception e){
			log.error("Logout is unsuccessful and the error is "+e);
		}
			
		}

}
