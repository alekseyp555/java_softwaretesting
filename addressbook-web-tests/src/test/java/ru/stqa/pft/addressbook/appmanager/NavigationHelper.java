package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void returnToContactCreation() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void gotoContactPage() {
    click(By.linkText("home"));
  }
}
