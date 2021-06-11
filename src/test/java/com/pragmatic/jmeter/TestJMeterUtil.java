package com.pragmatic.jmeter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class TestJMeterUtil {

    JmeterUtil util;

    @BeforeClass
    public void beforeClass() {
        util = new JmeterUtil();
    }

    @Test
    public void testJmeterUtil() {
        Assert.assertTrue(util.getFirstName().length() > 0);
    }


    @Test
    public void testGuardianFirstName() {
        Assert.assertTrue(util.getGuardianFirstName().length() > 0);
    }


    @Test
    public void testGuardianLastName() {
        Assert.assertTrue(util.getGuardianLastName().length() > 0);
    }

    @Test
    public void testChildFirstName() {
        Assert.assertTrue(util.getChildFirstName().length() > 0);
    }


    @Test
    public void testChildLastName() {
        Assert.assertTrue(util.getChildLastName().length() > 0);
    }

    @Test
    public void testMiddleName() {
        String middleName = util.getMiddleName();
        Assert.assertTrue(middleName.length() > 0);
        Assert.assertFalse(middleName.contains(" "));
    }


    @Test
    public void testEmail() {
        String email = util.getEmail();
        Assert.assertTrue(email.contains("@"));
        Assert.assertFalse(email.contains("null"));
    }

    @Test
    public void testMobile() {
        String phone = util.getMobile();
        Assert.assertTrue(phone.startsWith("04"), "Phone number does not contains prefix 04");
        Assert.assertEquals(phone.length(), 10, String.format("Phone length %s is not 10", phone.length()));
    }

    @Test
    public void testFamilyName() {
        Assert.assertTrue(util.getFamilyName().length() > 10);

    }

    @Test
    public void testChildCRN() {
        Assert.assertEquals(util.getChildCRN().length(), 10);
    }

    @Test
    public void testGuardianCRN() {
        Assert.assertEquals(util.getGuardianCRN().length(), 10);
    }

    @Test
    public void testParentCRN() {
        Assert.assertEquals(util.getParentCRN().length(), 10);
    }


    @Test
    public void testPaymentAccountName() {
        Assert.assertTrue(util.getPaymentAccountName().length() > 5);
        Assert.assertTrue(util.getPaymentAccountName().contains(" "));
    }

    @Test
    public void testGuardianDOB() {
        Assert.assertEquals(util.getGuardianDOB().length(), 10);
        Assert.assertTrue(util.getGuardianDOB().matches("^((19)[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"));

    }

    @Test
    public void testChildDOB() {
        Assert.assertEquals(util.getChildDOB().length(), 10);
        Assert.assertTrue(util.getChildDOB().matches("^((20[1-2])[0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"));
    }

    @Test
    public void testGetCurrentDate() {
        Assert.assertEquals(util.getCurrentDate().length(), 10);
        Assert.assertTrue(util.getCurrentDate().matches("^((20[1-2])[0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"));

    }

    @Test
    public void testGetPastDate() {
        Assert.assertEquals(util.getPastDate(30, 5).length(), 10);
        Assert.assertTrue(util.getPastDate(30, 5).matches("^((20[1-2])[0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"));
        Assert.assertFalse(util.getPastDate(30, 5).equalsIgnoreCase(util.getCurrentDate()));
    }


    @Test
    public void testGetBookingFromDate() {
        Assert.assertEquals(util.getBookingFromDate().length(), 10);
        Assert.assertTrue(util.getPastDate(30, 5).matches("^((20[1-2])[0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"));
    }


    @Test(enabled = false)
    public void testGetProfilePicture(){
            Assert.fail("Method is not implemented");
    }


    @Test(enabled = false)
    public void testGetProfilePictureName(){
        Assert.fail("Method is not implemented");
    }


    @Test
    public void testGetStreetAddress(){
        String streetAddress = util.getStreetAddress();
        Assert.assertTrue(streetAddress.length()>10);
    }

    @Test
    public void testGetSuburb(){
        String suburb = util.getSuburb();
        Assert.assertTrue(suburb.length()>3);
    }


    @Test
    public void testPostcode(){
        String postcode = util.getPostcode("NSW");
        System.out.println("postcode = " + postcode);
        Assert.assertTrue(postcode.length()==4);
    }


    @Test(invocationCount = 5)
    public void testTagName(){
        String tagName = util.getTagName();
        System.out.println("tagName = " + tagName);
        Assert.assertTrue(tagName.length()>5);

    }



}
