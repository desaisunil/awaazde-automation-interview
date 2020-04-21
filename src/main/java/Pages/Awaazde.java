package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

import Base.Methods;
import Objects.objects;
import afu.org.checkerframework.checker.regex.RegexUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Awaazde extends Methods {
	
	
	@BeforeTest
	public static void startup() {
		
		String url = "http://weathershopper.pythonanywhere.com/";
		
		driver = init();
		Methods.setup();
		driver.navigate().to(url);
		Wait();
		
	}
	
	
  @Test
  public static void weathershopper() 
  {
	  
	  int i = 19;
	  int j = 34;
	  
	  
	  String temp =  gettext(objects.temprature);
	  
		String temp1 = temp.substring(0, 2);
		String newTemp = temp1.substring(0, 2).trim();
		System.out.println("temp is " +newTemp );
		
		int Currenttemp = Integer.parseInt(newTemp);
		 
		
	
		  if(Currenttemp<i) 
		  {
			  System.out.println("buy a"); 
			  
			  List<Integer> pricelistvalue = new ArrayList<Integer>();
	           List<WebElement> pricelist = driver.findElements(By.xpath(".//p[contains(text(),'Aloe')]/parent::div/p[last()]"));
	            for (int i1 = 0; i1 < pricelist.size(); i1++)
	            {
	            	
	            	
	            	String element = pricelist.get(i).getText();
	            	 
	            	 String price = element.substring(0, 3);
	            	 Integer Rs =Integer.parseInt(price);
	                 pricelistvalue.add(Rs);
	                
	                
	            }
	            Integer value = Collections.min(pricelistvalue);
	            driver.findElement(By.xpath(".//p[contains(text(),'"+value+"')]/parent::div/button")).click();
			  
		  } 
		  else if(Currenttemp<j){
		  
		  System.out.println("buy b"); 
		  
		  
		  List<Integer> pricelistvalue = new ArrayList<Integer>();
           List<WebElement> pricelist = driver.findElements(By.xpath(".//p[contains(text(),'SPF-50')]/parent::div/p[last()]"));
            for (int i1 = 0; i1 < pricelist.size(); i1++)
            {
            	
            	
            	String element = pricelist.get(i).getText();
            	 
            	 String price = element.substring(0, 3);
            	 Integer Rs =Integer.parseInt(price);
                 pricelistvalue.add(Rs);
                
                
            }
            Integer value = Collections.min(pricelistvalue);
            driver.findElement(By.xpath(".//p[contains(text(),'"+value+"')]/parent::div/button")).click();
		  
		 
		  }
		  
		  else {
			  
			  System.out.println("Current temperature is Between 19 and 34"); 
		  }
  }
  
}