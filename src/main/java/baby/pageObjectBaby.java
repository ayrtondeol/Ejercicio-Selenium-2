package baby;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class pageObjectBaby extends launcherSelenium{
	WebElement element;
	int cont;
	JavascriptExecutor executor;
	List<WebElement> lista;
	private boolean check=false;
	
	By campobusqueda = By.cssSelector("input[class='gLFyf gsfi']");
	By messientoconsuerte = By.cssSelector("input[class='RNmpXc']");
	By letra = By.xpath("//div[@class='Lyrics__Container-sc-1ynbvzw-8 eOLwDW'] | //div[@class='Lyrics__Container-sc-1ynbvzw-8 faOUCe']");
	By letra2 = By.xpath("//section/p");
	 
	public void abrirGoogle()
	{
		launchSelenium("https://www.google.com/");
	}
	
	public void buscarCancion(String cancion)
	{
		if(cancion.isBlank())
		{
			System.out.println("No se ingreso ningun valor");
			driver.close();
		}
		driver.findElement(campobusqueda).sendKeys(cancion + " genius");
		waitDriver.until(ExpectedConditions.presenceOfElementLocated(messientoconsuerte));
	    element = driver.findElement(messientoconsuerte);
	    executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);	
	}
	
	public void buscarAlgo(String algo)
	{
		waitDriver.until(ExpectedConditions.or(
	    ExpectedConditions.presenceOfAllElementsLocatedBy(letra),
	    ExpectedConditions.presenceOfElementLocated(letra2)));
		if(elementoExiste(letra2))
		{
			element = driver.findElement(letra2);
			cont=0;
			contar(element, algo);
		}
		else
		{
			lista = driver.findElements(letra);
			cont=0;
		    for(int u = 0;u<lista.size();u++)
		    {
			contar(lista.get(u), algo);
		    }
		}
		System.out.println("El termino '"+ algo + "' aparece " + cont + " veces en la cancion");
		check=true;
		driver.quit();
}
	
	public boolean test()
	{
		if(check=true)
		{
			return true;
		}
	  return false;
	}
	
	public boolean elementoExiste(By path)
	{
		try
		{
			WebElement element;
			element = driver.findElement(path);
			element.isDisplayed();
			return true;
		}
	 catch(NoSuchElementException e)
	{
		return false;
	}
	}
	
	public void contar(WebElement element, String texto)
	{
		String array[] = element.getAttribute("innerText").toLowerCase().split(" ");
		for(int i=0; i<array.length;i++)
		{
			if(array[i].contains(texto))
			{
				cont++;
			}
	}
	}

}
