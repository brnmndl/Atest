package clients;

import java.awt.Robot;

import testng.AUTBaseTest;
import clients.ObjectRepository.googleScenario;

public class GoogleSearch extends AUTBaseTest
{
	public void searchAndCheck(String searchText,String maxWait,String expectedText,String linkClick,String toolTipCheck)
	{
		try
		{		    
			if (isElementDisplayed(googleScenario.textLocator, googleScenario.textBy))
			{
				setTextboxValue(googleScenario.textLocator, googleScenario.textBy,searchText);
				Thread.sleep(5000);
				try
				{
					Robot robo = new Robot();
					downKeyPressViaRobot(robo,1);
					pressEnterViaRobot(robo, 1);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				int waitTime = Integer.parseInt(maxWait);
				waitForAjaxObject(googleScenario.textLocator, googleScenario.textBy,waitTime,expectedText);
				if(isElementDisplayed(googleScenario.buttnLocator,googleScenario.buttnBy))
				{
					clickButton(googleScenario.buttnLocator,googleScenario.buttnBy);
				}
				clickWebLink(googleScenario.linkLocator,googleScenario.linkBy);
				String downloadToolTip = GetToolTipText(googleScenario.dwnLinkLocator,googleScenario.dwnLinkBy);
				assertEquals(downloadToolTip,toolTipCheck);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
