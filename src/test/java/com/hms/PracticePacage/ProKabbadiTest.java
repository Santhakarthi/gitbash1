package com.hms.PracticePacage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.prokabaddi.com/standings");
		List<WebElement> allTeams = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data team']"));
		List<WebElement> allMatches = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-play']"));
		List<WebElement> matchesWon = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-won' ]"));
		List<WebElement> matchesLost = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-lost' ]"));
		List<WebElement> matchesDraw = driver.findElements(By.xpath("//div[@class='table-body']/descendant::div[@class='table-data matches-draw' ]"));
	  String team = "Jaipur Pink Panthers";
		System.out.println("Name of the team---->Matches Played---->Matches Won---->Matches Lost---->Matches Draw");
		
		for (int i = 0; i < allTeams.size(); i++) {
			
			String teamName = allTeams.get(i).getText();
			if(teamName.equalsIgnoreCase(team)) {
			String scoreBoard = allTeams.get(i).getText()+"--->"+allMatches.get(i).getText()+"--->"+matchesWon.get(i).getText()+"---->"+matchesLost.get(i).getText()+"---->"+matchesDraw.get(i).getText();
			System.out.println(scoreBoard);

	}

}
	}
}
