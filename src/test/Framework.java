package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.AUTBaseTest;
import clients.GoogleSearch;
import clients.ObjectRepository.googleScenario;

public class Framework extends AUTBaseTest
{
	@DataProvider (name = "googlescenario")
	public Object[][] testDataScenario() throws Exception
	{
		Object[][] data = getTableArray(Main.DataFilePath,"data","googlescenario");
		return(data);
	}
	
	@Test( dataProvider = "googlescenario")
	public void googleScenario(String browserName,String browseURL,String searchText,String maxWait,String expectedText,String linkClick,String toolTipCheck)
	{
		ReportsConfig();
		setupBrowserAbsDriverPath(browserName,Main.Chrome_ConfigFilePath);
		accessHomePage(browseURL,googleScenario.textLocator,googleScenario.textBy);
		GoogleSearch gs = new GoogleSearch();
		gs.searchAndCheck(searchText,maxWait,expectedText,linkClick,toolTipCheck);
	}
}