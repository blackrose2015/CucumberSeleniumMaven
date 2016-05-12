package CucumberMaven.CucumberMaven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TETRApages {
	
	private WebDriver driver;
    private int timeout = 15;
    private final String pageLoadedText = "Copyright © 2010-2014 Launchworks, Inc. All rights reserved";
    @FindBy(name = "UserName")
    private WebElement username;
    
    @FindBy(name = "Password")
    private WebElement password;
    
    @FindBy(css = "input[value=Login]")
    private WebElement submit;
    

    //@FindBy(xpath = "//*[@id='1541']/td[1]/a[2]")
    @FindBy(linkText = "R12 - Installation Fitness Report")
    private WebElement  report_Installation;
    
    @FindBy(xpath = "//*[@id='searchbtn_586']")
     private WebElement  services_Component;
    
    @FindBy(id="availitems_586")
    private WebElement selected_Component_Choices;
        
    @FindBy(id="additem_586")
    private WebElement add_Component_Choices;
    
    @FindBy(id="custExpand_586")
    private WebElement hide_Component_Choices_List;
    
    @FindBy(xpath = "//*[@id='searchbtn_587']")
    private WebElement  search_File_Types;
    
    @FindBy(id="availitems_587")
    private WebElement selected_File_Types;
    
    @FindBy(id="additem_587")
    private WebElement add_File_Types;
    
    @FindBy(id="custExpand_587")
    private WebElement hide_File_Type_List;
    
    @FindBy(xpath = "//*[@id='searchbtn_589']")
    private WebElement  search_Installation;
    
    @FindBy(id="availitems_589")
    private WebElement selected_Installation;
    
    @FindBy(id="additem_589")
    private WebElement add_Installation;
    
    @FindBy(id="custExpand_589")
    private WebElement hide_Installation;

    @FindBy(xpath = "//*[@id='searchbtn_588']")
    private WebElement  search_MAJCOM;
    
    @FindBy(id="availitems_588")
    private WebElement selected_MAJCOM;
    
    @FindBy(id="additem_588")
    private WebElement add_MAJCOM;
    
    @FindBy(id="custExpand_588")
    private WebElement hide_MAJCOM;
    
  //*[@id="paramviewerOptions"]/tbody/tr[2]/td
    @FindBy(xpath = "//input[@value='XLS']")
    private WebElement xlsChoose;
    
    
    @FindBy(xpath = "//*[@id='prompt_action']/input")
    private WebElement runReport;
    
    @FindBy(xpath = "//*[@id='progress']/p/a")
    private WebElement firstBack;
 
    @FindBy(xpath = "//*[@id='prompt_action']/a[3]")
    private WebElement secondBack;
       
     
    @FindBy(linkText = "R13 - MAJCOM Fitness Report")
    private WebElement  report_MAJCOM;
    
    
    @FindBy(xpath = "//input[@value='PDF']")
    private WebElement pdfChoose;
    
    public TETRApages() {
    }

    public TETRApages(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public TETRApages(WebDriver driver, int timeout) {
    	this();
    	this.driver = driver;
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    public TETRApages setUsername(String text) {
        username.sendKeys(text);
        return this;
    }
    
    public TETRApages setPassword(String text) {
        password.sendKeys(text);
        return this;
    }
    
   
    public TETRApages clickLoginBnt() {
        submit.click();
        return this;
    }

    /**
     * Click on Report Installation Link.
     *
     * @return new window for report.
     */
    public TETRApages click_report_Installation() {
    	report_Installation.click();
        return this;
    }
    
    /**
     * Click on Service Component.
     *
     * @return new windows to choose for report
     */
    public TETRApages click_services_component() {
    	services_Component.click();
        return this;
    }
    
    
    /**
     * Click on search button for Service Component.
     *
     * @return values of search button are selected 
     */
    public TETRApages selectedList(int types) {
    	
    Select dropdown = null;
    if (types==0)
    {
    	dropdown = new Select(selected_Component_Choices);
    }
    if (types==1){
    	dropdown = new Select(selected_File_Types);
    	
    }
     
    if (types==2){
    	dropdown = new Select(selected_Installation);
   	
    }
    
    if (types==3){
    	dropdown = new Select(selected_MAJCOM);
   	
    }
    	final List<WebElement> options = dropdown.getOptions();
    	
    	for (int i=0;i<options.size();i++)
    	{
    		String iValue=options.get(i).getText();
    		System.out.println("Value " +i +" is : "+iValue);
    		dropdown.selectByIndex(i);
      	}

        return this;
    }
    
     
    /**
     * Click to add Component Services.
     *
     * @return list of component services.
     */
    public TETRApages add_Component_Choices() {
    	add_Component_Choices.click();
        return this;
    }
    
    /**
     * Click to Hide Component Services List.
     *
     * @return hide list of component services.
     */
    public TETRApages hide_Component_Choices_List() {
    	hide_Component_Choices_List.click();
        return this;
    }
    
    /**
     * Click to search File Types.
     *
     * @return list of search Files types.
     */
    public TETRApages search_file_Types() {
    	search_File_Types.click();
        return this;
    }
    
    /**
     * Click to add File Types.
     *
     * @return list of Files types.
     */
    public TETRApages add_File_Types() {
    	add_File_Types.click();
        return this;
    }
    
    /**
     * Click to Hide File Type List.
     *
     * @return hide list of File Types.
     */
    public TETRApages hide_File_Type_List() {
    	hide_File_Type_List.click();
        return this;
    }
    
    
    
    /**
     * Click to search Installation.
     *
     * @return list of search installation
     */
    public TETRApages search_Installation() {
    	search_Installation.click();
        return this;
    }
    
    
    /**
     * Click to add Installation
     *
     * @return list of installation
     */
    public TETRApages add_Installation() {
    	add_Installation.click();
        return this;
    }
    
    /**
     * Click to Hide File Type List.
     *
     * @return hide list of File Types.
     */
    public TETRApages hide_Installation() {
    	hide_Installation.click();
        return this;
    }
    
    /**
     * Click to search MAJCOM.
     *
     * @return list of search MAJCOM
     */
    public TETRApages search_MAJCOM() {
    	search_MAJCOM.click();
        return this;
    }
    
    /**
     * Click to add MAJCOM
     *
     * @return list of MAJCOM
     */
    public TETRApages add_MAJCOM() {
    	add_MAJCOM.click();
        return this;
    }
    
    /**
     * Click to Hide MAJCOM List.
     *
     * @return hide list of MAJCOM List.
     */
    public TETRApages hide_MAJCOM() {
    	hide_MAJCOM.click();
        return this;
    }
    /**
     * Click to run report.
     *
     * @return report
     */
    
    public TETRApages clickRunReport() {
        runReport.click();
        return this;
    }

    
    /**
     * Click to choose xls.
     *
     * 
     */
    
    public TETRApages clickChooseXLS() {
        xlsChoose.click();
        return this;
    }

    /**
     * Click to first Back.
     *
     * 
     */
    
    public TETRApages firstBack() {
        firstBack.click();
        return this;
    }
    
    /**
     * Click to second Back.
     *
     * 
     */
    
    public TETRApages secondBack() {
        secondBack.click();
        return this;
    }
    
    /**
     * Click to MAJCOM report.
     * @return new window for MAJCOM
     *
     * 
     */
    
    public TETRApages report_MAJCOM() {
        report_MAJCOM.click();
        return this;
    }
    
    /**
     * Click to pdfChoose report.
     * 
     * 
     */
    
    public TETRApages pdfChoose() {
        pdfChoose.click();
        return this;
    }
    
    /*
     * Check to load the pages
     * */
    public TETRApages verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

	public boolean selected_Component_Choices_display() {
		// TODO Auto-generated method stub
		if (selected_Component_Choices.isDisplayed()){
    		return true;
    	}
    	else
    	{
    		return false;
		}
	}
	
	public boolean selected_File_Types() {
		// TODO Auto-generated method stub
		if (selected_File_Types.isDisplayed()){
    		return true;
    	}
    	else
    	{
    		return false;
		}
	}

	
	public boolean selected_Installation() {
		// TODO Auto-generated method stub
		if (selected_Installation.isDisplayed()){
    		return true;
    	}
    	else
    	{
    		return false;
		}
	}

	public boolean selected_MAJCOM() {
		// TODO Auto-generated method stub
		if (selected_MAJCOM.isDisplayed()){
    		return true;
    	}
    	else
    	{
    		return false;
		}
	}
	
	 

}
