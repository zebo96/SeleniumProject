package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homeworkBankCustomerPage {
    public homeworkBankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement select;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;
    @FindBy(xpath = "//button[contains(text(), 'Deposit')]")
    WebElement depositButton;
    @FindBy(tagName = "input")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement confirmDeposit;
    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    WebElement message;
    @FindBy(xpath = "//button[contains(text(), 'Withdrawl')]")
    WebElement withdrawlButton;
    @FindBy(tagName = "input")
    WebElement withdrawAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement confirmWithdrawl;
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement message2;
    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement currentBalance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawlDebit;

    public void chooseName(String valueNumber){
        BrowserUtils.selectBy(select,valueNumber, "value");
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void validateWelcome(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }
    public void clickDepositButton(){
        depositButton.click();
    }
    public void enterAmount(String money){
        amount.sendKeys(money);
    }
    public void clickConfirmDepositButton(){
        confirmDeposit.click();
    }
    public void validateMessage(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
    }
    public void clickWithdrawlButton(){
        withdrawlButton.click();
    }
    public void withdrawthisAmount(String money2){
        withdrawAmount.sendKeys(money2);
    }
    public void clickConfirmWithdrawlButton(){
        confirmWithdrawl.click();
    }
    public void validateMessage2(String expectedMessage2){
        Assert.assertEquals(BrowserUtils.getText(message2), expectedMessage2);
    }
    public void transactionFunctionality(){
        int actualBalance=Integer.parseInt(BrowserUtils.getText(currentBalance));
        transactionsButton.click();
        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(depositCredit))- Integer.parseInt(BrowserUtils.getText(withdrawlDebit)));
        Assert.assertEquals(actualBalance, expectedBalance);
    }
}
