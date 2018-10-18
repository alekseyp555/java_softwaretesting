package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTestDB extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Delete").withLastname("Deletion"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/cumis.png");
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Petr").withMiddlename("Petrovich").
            withLastname("Ivanov").withAddress("Moscow Red squre 1 h1").
            withHomephone("+79153925555").withNickname("Ivan_01").withGroup("Test1").withPhoto(photo);
    app.contact().modify(contact);
 //   Assert.assertEquals(app.group().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }

}
