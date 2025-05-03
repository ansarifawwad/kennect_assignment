package org.example.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@name='email']")
    public   WebElement enterUsername;

    @FindBy(xpath = "//input[@name='password']")
    public    WebElement enterPassword;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    public  WebElement loginButton;

    @FindBy(id = "patient-test")
    public  WebElement clickAddTests;

    @FindBy(id = "//li[@id='patient-test-option-0']//input[@type='checkbox']")
    public WebElement clickPatient;

    @FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
    public  WebElement clickDiscountsList;

    @FindBy(xpath = "//li[normalize-space()='5%']")
    public  WebElement clickDiscount;

    @FindBy(xpath = "//span[@class='MuiButton-label'][normalize-space()='Add']")
    public  WebElement clickAddToDo;

    @FindBy(id="outlined-add-todo-input")
    public  WebElement enterTodo;






}
