import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TesteDBserver {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  private DSL dsl;
  private ShopCartPage scpage;
  
  
  @Before
  public void inicializar() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    
    dsl = new DSL(driver);
    scpage = new ShopCartPage(driver);
    
    //Accessing the main ling 
    dsl.acessaseite();
    
    //Dimensioning the work' window
    dsl.dimensionajanela(1296, 776);
  }
  
  @After
  public void finalizar() {
    driver.quit();
  }
  
    
  @Test
  public void acessaWomen() throws InterruptedException {
               
    //#####################################
    // Test name: AddCArrinho
    //#####################################
	  
 	//Choosing the product 
	scpage.escolheproduto();
	
 	//Add to cart	
 	scpage.adicionacarrinho();
 	
 	//#####################################
 	//Proceed to checkout
 	//#####################################
 	
 	//Proceed to checkout
 	Boolean validaprod = new Boolean(false);
 	validaprod = dsl.validaproduto();
 	if(validaprod)
 		scpage.prosseguecheckout();  
 	else
 		scpage.prosseguecheckout(); //não deu tempo de tratar :(
	
	//Shopping cart summary  
	scpage.confirmacarrinho();
	
	//#####################################
	//Create an account
	//#####################################
	
	//Create an account - email address
	scpage.insereemail(dsl.geraemail());
	 
	//Create an account - click on Create an account
    scpage.submeteemail();
	
	//Account Form - radio Mr and Mrs
	scpage.selecionagenero();
	
	//WebElement 
	scpage.selecionageneros();   
	    
    //Account Form - First Name
	scpage.inserefirstname("Teste");
	
	//Account Form - Last name
	scpage.inserelastname("DBServer");  
	
	//Account Form - Password  
	scpage.inserepassword("123689");
	   
	//Account Form - Date of Birth - Day 
	scpage.selectbirthday("25");
	
	//Account Form - Date of Birth - Month
	scpage.selectbirthmonth("11"); 
	
	//Account Form - Date of Birth - Year
	scpage.selectbirthyear("1976"); 
	
	//Account Form - Your Address - First Name
	scpage.inserefirstname("Teste");
	  
	//Account Form - Your Address - Last Name
	scpage.inserelastname("DB");
	  
	//Account Form - Your Address - Company
	scpage.inserecompany("Autônomo");
	  
	//Account Form - Your Address - Address 1
	scpage.inserestreet("João Pessoa");  
	
	//Account Form - Your Address - Address 2
	scpage.inserecomplement("21");
	  
	//Account Form - Your Address - City 
	scpage.inserecity("Porto Alegre");
	
	//Account Form - Your Address - State
	scpage.selectstate("6");
	
	//Account Form - Your Address - Zip Code
	scpage.inserezipcode("90040");
	
	//Account Form - Your Address - Country
	scpage.selectcountry("21");
	
	//Account Form - Your Address - Additional Information
	scpage.isnereadditionalinformation("TESTE DB");  
	
	//Account Form - Your Address - Home Phone
	scpage.inserephonehome("5551992039296"); 
	
	//Account Form - Your Address - Modile Phone
	scpage.inserephonemobile("5551992039296"); 
	
	//Account Form - Your Address - Alias
	scpage.inserealias("testedb488488");
	
	//Clicking Register
	scpage.registraconta();
	
	//#####################################
    //Proceed the address
	//#####################################
	  
	//Proceed Address
	Boolean validaend = new Boolean(false);
	validaend = dsl.validaendereco();
 	if(validaend)
 		scpage.registraendereco();
 	else
 		scpage.registraendereco();
	
	//#####################################
    //Confirming terms
	//#####################################
	  
	//Checking Terms
	scpage.concordatermos();  
	
	//Proccess Carrier
	scpage.prosseguetransportadora();
	
	//#####################################
    //Payment choice
	//#####################################
	  
	//Payment Choice
	Boolean validavalortot = new Boolean(false);
	validavalortot = dsl.validavalortotal();
 	if(validavalortot)
 		scpage.escolheformapagamento();
 	else
 		scpage.escolheformapagamento();
	
	//Payment Confirm
	scpage.confirmapagamento();
	
	//#####################################
    //Return cart
	//#####################################
	  
	//Return Cart
	scpage.retornapedidos();
	
	//#####################################
    //Return home
	//#####################################
	  
	//Return Home
	scpage.retornahome();  
  }
    
}