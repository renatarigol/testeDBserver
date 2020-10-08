import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;	

public class ShopCartPage {
	
	private DSL dsl;
	
	//Construct class
	public ShopCartPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void escolheproduto() {
		dsl.clicarbyxpat("(//img[@class='replace-2x img-responsive'])[1]");
	}
	
	public void adicionacarrinho() {
		dsl.clicarbyxpat("//button[@name='Submit']//span[1]");
	}
	
	public void prosseguecheckout() {
		dsl.clicarbywaitclicablexpat("//span[text()[normalize-space()='Proceed to checkout']]", 20);
	}
	
	public void confirmacarrinho() {
		dsl.clicarbyxpat("//a[contains(@class,'button btn')]//span[1]");
	}
	
	public void insereemail(String email) {
		dsl.escreverbycss("input#email_create", email);
	}
	
	public void submeteemail() {
		dsl.clicarbywaitclicablexpat("//button[@name='SubmitCreate']//span[1]", 20);
	}
	
	public void selecionagenero() {
		dsl.clicarbywaitclicablexpat("//*[@id=\"id_gender2\"]",20);
	}
	
	public void selecionageneros() {
		dsl.radioclickxpat("//*[@id=\"id_gender2\"]");
	}
		
	public void inserefirstname(String firstname) {
		dsl.escreverbyxpat("(//input[@data-validate='isName'])[1]", firstname);		
	}
	
	public void inserelastname(String lastname) {
		dsl.escreverbyxpat("//label[@for='customer_lastname']/following-sibling::input[1]", lastname);		
	}
	
	public void inserepassword(String password) {
		dsl.escreverbyxpat("//div[contains(@class,'required password')]//input[1]", password);
	}
	
	public void selectbirthday(String day) {
		dsl.selecionavalorxpat("//div[@id='uniform-days']//select[1]", day);
	}
	
	public void selectbirthmonth(String month) {
		dsl.selecionavalorxpat("//div[@id='uniform-months']//select[1]", month);
	}
	
	public void selectbirthyear(String year) {
		dsl.selecionavalorxpat("//div[@id='uniform-years']//select[1]", year);
	}
	
	public void inserecompany(String company) {
		dsl.escreverbyxpat("(//p[@class='form-group']//input)[1]", company);
	}
	
	public void inserestreet(String street) {
		dsl.escreverbyxpat("(//p[@class='required form-group']//input)[3]", street);
	}
	
	public void inserecomplement(String complement) {
		dsl.escreverbyxpat("//p[@class='form-group is_customer_param']//input[1]", complement);
	}
	
	public void inserecity(String city) {
		dsl.escreverbyxpat("(//p[@class='required form-group']//input)[4]", city);
	}
	
	public void selectstate(String state) {
		dsl.selecionavalorxpat("//div[@id='uniform-id_state']//select[1]", state);
	}
	
	public void inserezipcode(String zipcode) {
		dsl.escreverbyxpat("//p[contains(@class,'required postcode')]//input[1]", zipcode);
	}
	
	public void selectcountry(String country) {
		dsl.selecionavalorxpat("//div[@id='uniform-id_country']//select[1]", country);
	}
	
	public void isnereadditionalinformation(String additionalinformation) {
		dsl.escreverbyxpat("//p[@class='textarea form-group']//textarea[1]", additionalinformation);
	}
	
	public void inserephonehome(String phonehome) {
		dsl.escreverbyxpat("(//p[@class='form-group']//input)[2]", phonehome);
	}
	
	public void inserephonemobile(String phonemobile) {
		dsl.escreverbyxpat("(//p[@class='required form-group']//input)[5]", phonemobile);
	}
	
	public void inserealias(String alias) {
		dsl.escreverbyxpat("//p[@id='address_alias']//input[1]", alias);
	}
	
	public void registraconta() {
		dsl.clicarbywaitclicablexpat("//button[@name='submitAccount']//span[1]", 20);
	}
	
	public void registraendereco() {
		dsl.clicarbywaitclicablexpat("//button[@name='processAddress']//span[1]", 20);
	}
	
	public void concordatermos() {
		dsl.clicarbyxpat("//div[@id='uniform-cgv']//input[1]");
	}
	
	public void prosseguetransportadora() {
		dsl.clicarbywaitclicablexpat("//button[@name='processCarrier']//span[1]", 20);
	}
	
	public void escolheformapagamento() {
		dsl.clicarbywaitclicablexpat("(//p[@class='payment_module']//a)[1]", 20);
	}
	
	public void confirmapagamento() {
		dsl.clicarbywaitclicablexpat("//button[contains(@class,'button btn')]//span[1]", 20);
	}
	
	public void retornapedidos() {
		dsl.clicarbywaitclicablexpat("//p[@class='cart_navigation exclusive']//a[1]", 20);
	}
	
	public void retornahome() {
		dsl.clicarbywaitclicablexpat("(//a[contains(@class,'btn btn-default')]//span)[5]", 20);
	}

}
