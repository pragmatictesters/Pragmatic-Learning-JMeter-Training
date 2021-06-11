package com.pragmatic.jmeter;

import org.apache.jmeter.threads.JMeterVariables;
import org.testng.annotations.Test;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class TestVars {

    @Test
    public void testVars() {

        JMeterVariables vars = new JMeterVariables();
        JmeterUtil util = new JmeterUtil();


        vars.put("paymentAccountName", util.getPaymentAccountName());
        vars.put("guardianFirstName", util.getGuardianFirstName());
        vars.put("guardianLastName", util.getGuardianLastName());
        vars.put("guardianDOB", util.getGuardianDOB());
        vars.put("guardianCRN", util.getGuardianCRN());
        vars.put("email", util.getEmail());
        vars.put("mobile", util.getMobile());

        vars.put("childFirstName", util.getChildFirstName());
        vars.put("childLastName", util.getChildLastName());
        vars.put("childDOB", util.getChildDOB());
        vars.put("childCRN", util.getChildCRN());
        vars.put("familyName", util.getFamilyName());

        vars.put("streetAddress", util.getStreetAddress());
        vars.put("streetLine1", util.getStreetAddress());
        vars.put("postcode", util.getPostcode("NSW"));
        vars.put("suburb", util.getSuburb());


        vars.put("tagName", util.getTagName());
        vars.put("tagDescription", util.getTagName());








    }
}
