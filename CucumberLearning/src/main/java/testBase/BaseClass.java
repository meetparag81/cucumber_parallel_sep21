package testBase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vandeseer.easytable.drawing.Drawer;

import utilities.Constants;

public class BaseClass {
    protected WebDriverWait wait;
    protected WebDriver driver;

    
    public BaseClass(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT);
    }

    @FindBy 
    public WebElement Loader;

    public void SelectBox(WebElement item)
    {
        WaitForClickable(item);
        if (!item.isSelected())
        {
            item.click();
        }
    }

    public void UnSelectBox(WebElement item)
    {
        WaitForClickable(item);
        if (item.isSelected())
        {
            item.click();
        }
    }

    public void refreshbrowser()
    {
        driver.navigate().refresh();
        waitforPageLoad(driver);
    }

    public void clickusingJavaScript(WebElement element)

    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public boolean IsElementExists(WebElement element)
    {
         boolean result = false;
        try
        {
            if (element.isDisplayed())
                result = true;
        }
        catch (Exception e)
        {
            result = false;
        }
        return result;
    }

    public boolean IsElementEnabled(WebElement element)
    {
        boolean result = false;
        try
        {
            if (element.isEnabled())
                result = true;
        }
        catch (Exception e)
        {
            result = false;
        }
        return result;
    }

    public void HandleBox(WebElement item, Boolean selected)
    {
        WaitForClickable(item);
        if (selected)
        {
            SelectBox(item);
        }
        else
        {
            UnSelectBox(item);
        }
    }

    public void SelectByText(WebElement selElement, String text)
    {
        WaitForClickable(selElement);
        Select item = new Select(selElement);
        item.selectByVisibleText(text);
    }

    public void SelectByValue(WebElement selElement, String value)
    {
        WaitForClickable(selElement);
        Select item = new Select(selElement);
        item.selectByValue(value);
    }

    public void EnterText(WebElement input, String text)
    {
        try
        {
            if (text.equalsIgnoreCase("") != false)
                return;
            WaitForClickable(input);
            JavascriptExecutor js =  (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].value =''", input);
            if (text.equals("NULL"))
                return;
            input.sendKeys(text);
        }
        catch (Exception e)
        {
            input.sendKeys(text);
        }
    }

    public void Click(WebElement elem)
    {
        WaitForClickable(elem);
        elem.submit();
    }

    public void Clear(WebElement elem)
    {
        WaitForClickable(elem);
        elem.clear();
    }

    public void Close()
    {
        driver.close();
    }

    public void ExecuteJavaScript(String scriptToExecute, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(scriptToExecute, element);
    }

    public void SpecialClick(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().build().perform();
    }

    public void hover(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }

    public void changeWait(int waitTime)
    {
        driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS );
    }

    public void resetWait()
    {
    	driver.manage().timeouts().implicitlyWait(Constants.WEBDRIVER_TIMEOUT, TimeUnit.SECONDS );
    }

    public void WaitForClickable(WebElement element)
    {
        try
        {
            WaitForjQuerytoLoad();
            new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT)
            .until(ExpectedConditions.elementToBeClickable(element));
            do
            {
                Thread.sleep(100);
            }
            while (!IsElementEnabled(element));
            waitforPageLoad(driver);
            WaitForjQuerytoLoad();
        }
        catch (Exception e)
        {
            
        }
    }
    public boolean WaitForClickableReturn(WebElement element)
    {
    	boolean status;
        try
        {
            status = true;
            WaitForjQuerytoLoad();
            new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT)
            .until(ExpectedConditions.elementToBeClickable(element));
            do
            {
                
            }
            while (!IsElementVisible(element));
            waitforPageLoad(driver);
            WaitForjQuerytoLoad();
        }
        catch (Exception e)
        {
            
            status = false;
        }
        return status;
    }

    public boolean IsElementVisible(WebElement element)
    {
        return element.isDisplayed() && element.isEnabled();
    }

    public void waitforPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
}

    public void SelectFromDropDown(WebElement element, String sValue)
    {
        if (element.isEnabled() == true)
        {
            Select dropdown = new Select(element);
            String content = element.getText();
            if (!content.equals(sValue))
                dropdown.selectByVisibleText(sValue);
        }
    }

    public String GetValueFromTextBox(WebElement element)
    {
        String ActualText;
        if (element != null)
        {
            ActualText = element.getAttribute("value");
        }
        else
            ActualText = null;
        return ActualText;
    }

    public String GetTitle(WebElement element)
    {
        String ActualText;
        if (element != null)
        {
            ActualText = element.getAttribute("title");
        }
        else
            ActualText = null;
        return ActualText;
    }


    public void SendKeyPressToElement(WebElement elm, String Key)
    {
        if (elm != null)
        {
            WaitForClickable(elm);
            if (Key.equals("ENTER"))
            {
                try
                {
                    elm.sendKeys(Keys.ENTER);
                }
                catch (Exception e)
                {
                   
                }
            }
            else if (Key.equals("TAB"))
            {
                elm.sendKeys(Keys.TAB);
            }
            else if (Key.equals("DOWN"))
            {
                elm.sendKeys(Keys.DOWN);
            }
            else if (Key.equals("DEL"))
            {
                elm.sendKeys(Keys.DELETE);
            }
            else if (Key.equals("PGDN"))
            {
                elm.sendKeys(Keys.PAGE_DOWN);
            }
        }
    }

    public String GetText(WebElement element)
    {
        String content = null;
        if (element != null)
            try
            {
                content = element.getText();
            }
            catch (Exception e)
            {
               
            }
        return content;
    }

    public void selectElementfromDropDownContains(WebElement element, String sValue)
    {
         
        String content = element.getText();
        Select dropdown = new Select(element);
        List<WebElement> sOptions = dropdown.getOptions();
        for (WebElement s : sOptions) {
			
		
        
            if (s.getText().contains(sValue) && !sValue.contains(content))
            {
                dropdown.selectByVisibleText(s.getText());
                element.sendKeys(Keys.ENTER);
            }
        }
    }

    public List<String> GetTableText(WebElement element)
    {
        String rowText = "";
        List<String> sElementText = new ArrayList();
        List<WebElement> child = FindChildren(element);
        if (child != null)
        {
            for (WebElement we : child)
            {
                rowText = we.getText().trim();
                if (rowText != null)
                {
                    sElementText.add(rowText);
                }
            }
        }
        return sElementText;
    }

    public void setAttribute(WebElement element, String attributeName, String attributeValue)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attributeName, attributeValue);
    }

    public List<WebElement> FindChildren(WebElement element)
    {
        return element.findElements(By.tagName("tr"));
    }

    public WebElement GetTableRow(WebElement element, String expected)
    {
        WebElement tableObject = null;
        List<String> tablelist = new ArrayList<String>();
        List<WebElement> child = FindChildren(element);
        if (child != null)
        {
           for (WebElement we : child) {
			
		}
        	for (WebElement we1 : child)
            {
                String rowText = we1.getText().trim();
                if (rowText.indexOf(expected.trim()) >= 0)
                {
                    tableObject = we1;
                    break;
                }
            }
        }
        return tableObject;
    }

    public WebElement GetLastTableRow(WebElement element)
    {
        WebElement tableObject = null;
        List<String> tablelist = new ArrayList<String>();
        List<WebElement> child = FindChildren(element);
        if (child != null)
        {
            int size = child.size();
            do
            {
                size--;
                tableObject = child.get(size);
            } while ((child.get(size).getText().contains("Canceled")));
        }
        return tableObject;
    }

    public void acceptAlert()
    {
        if (wait.until(ExpectedConditions.alertIsPresent()) != null)
        {
             Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void dismissAlert()
    {
        if (wait.until(ExpectedConditions.alertIsPresent()) != null)
        {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void VerifyTableText(WebElement element, String sText)
    {
        String sElementText = null;
        sText = sText.trim().toUpperCase();
        boolean bFound = false;
        List<WebElement> child = findChildren(element);
        if (child != null)
        {
            for (WebElement we : child)
            {
                sElementText = we.getText().trim().toUpperCase();
                if (sElementText.contains(sText.trim()))
                {
                    bFound = true;
                    break;
                }
            }
        }
        Assert.assertEquals(bFound, "Expected text: " + sText + " Table contents: " + element.getText());
    }

    public List<WebElement> findChildren(WebElement element)
    {
        return element.findElements(By.tagName("tr"));
    }

    public boolean isAlertPresent()
    {
        boolean foundAlert = false;
        WebDriverWait waitDriver = new WebDriverWait(driver,10);
        try
        {
            waitDriver.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        }
        catch (Exception e)
        {
            foundAlert = false;
        }
        return foundAlert;
    }

    public void VerifyreadOnly(WebElement element)
    {
        Assert.assertEquals("true", element.getAttribute("aria-readonly"));
    }

    public void VerifyreadOnlywithreadonly(WebElement element)
    {
        Assert.assertEquals("true", element.getAttribute("readonly"));
    }

    public void VerifyTextPresent(WebElement elm, String sExpected)
    {
        String sActual = GetText(elm);
        Assert.assertEquals(sActual,sExpected, "Verify Text '" + sActual + "' contains '" + sExpected + "'");
    }

    public void WaitForjQuerytoLoad()
    {
        
        WebDriverWait waitDriver = new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT);
        try
        {
        	 waitDriver.ignoring(TimeoutException.class,StaleElementReferenceException.class);
            JavascriptExecutor js = (JavascriptExecutor)driver;
                       js.executeScript("return !window.ajaxActive == true");
                       js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
        }
        catch (Exception e)
        {
            
        }
		
    }

    public void WaitForSpinnertodisappear()
    {
        try
        {
            WaitForAjaxcall();
        }
        catch (Exception e)
        {
        	if (e.getCause().equals( WebDriverException.class) || e.getCause().equals(StaleElementReferenceException.class) || e.getCause().equals(NoSuchElementException.class))
            {
                
            }
        }
    }

    public void WaitForAjaxcall()
    {
        try
        {
            if (driver.findElement(By.cssSelector("div[role=progressbar]")).isDisplayed() == true)
            {
                WebElement els = driver.findElement(By.cssSelector("div[role=progressbar]"));

                /*check if above css is not working-----   div[title='Please wait']  */
                /*check if above css is not working-----   section[role=application]  */
                /*check if above css is not working-----   div[role=progressbar]  */
                new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT).until(ExpectedConditions.stalenessOf(els));
            }
        }
        catch (Exception e)
        {
            
        }
    }

    public static WebElement GetParent(WebElement e)
    {
        return e.findElement(By.xpath(".."));
    }
}


