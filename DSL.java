import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class DSL {
	
	private WebDriver driver;
		
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessaseite() {		
		driver.get("http://automationpractice.com/index.php?");
	}
	
	public void dimensionajanela(int a, int b) {
		driver.manage().window().setSize(new Dimension(a, b));
	}
		
	public void escreverbycss(String csscampo, String textoescrever) {		
		driver.findElement(By.cssSelector(csscampo)).sendKeys(textoescrever);		
	}
	
	public void escreverbyxpat(String xpathcampo, String textoescrever) {
		WebElement variaveltexto = driver.findElement(By.xpath(xpathcampo));
		variaveltexto.sendKeys(textoescrever);
	}
	
	public void clicarbyxpat(String xpahtcampo) {		
		driver.findElement(By.xpath(xpahtcampo)).click();		
	}	
	
	 public boolean validaproduto(){
		String testeProduto = driver.findElement(By.xpath("//h1[text()='Faded Short Sleeve T-shirts']")).getText();
			
		String resultadoesperado = new String();
		resultadoesperado ="Faded Short Sleeve T-shirts";
									
		try{
		Assert.assertEquals(testeProduto, resultadoesperado);
		}catch(Throwable t){
		     return false;
		}		  
		  return true;
	} 	
	 
	public boolean validaendereco() {
		String testendereco = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[4]")).getText();
		
		String resultadoesperado = new String();
		resultadoesperado ="joão pessoa 21";
									
		try{
		Assert.assertEquals(testendereco, resultadoesperado);
		}catch(Throwable t){
		     return false;
		}		  
		  return true;
	}
	
	public boolean validavalortotal() {
		String testevalortotal = driver.findElement(By.id("total_price")).getText();
		
		String resultadoesperado = new String();
		resultadoesperado ="$18.51";
									
		try{
		Assert.assertEquals(testevalortotal, resultadoesperado);
		}catch(Throwable t){
		     return false;
		}		  
		  return true;
	}
	
	public void clicarbywaitclicablexpat(String xpathcampo, int tempo) {
		new WebDriverWait(driver, tempo).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathcampo))).click();
	}
	
	public void radioclickxpat(String xpathcampo) {
		WebElement radio = driver.findElement(By.xpath(xpathcampo));
		radio.click();
	}
	
	public void selecionavalorxpat(String xpathcampo, String valorselecionar) {
		WebElement selecionar = driver.findElement(By.xpath(xpathcampo)); 
		new Select(selecionar).selectByValue(valorselecionar);
	}
	
	public String geraemail() {
		String email = new String();
		String convertnumero = new String();
		int numero = 0;
		
		Random numerorandomico = new Random();
		numero = numerorandomico.nextInt(999);
		convertnumero = String.valueOf(numero);
		
		email = "teste"+convertnumero+"@gmail.com";
		
		return email;
	}
}
