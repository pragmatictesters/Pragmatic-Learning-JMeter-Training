package com.pragmatic.jmeter.plugin.dummy.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.logging.log4j.util.Strings;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class DummySampler extends AbstractSampler {

    private static final String RESPONSE_TIME_PROPERTY = "Dummy.responseTime";
    private static final String LABEL = "Dummy.label";
    private static final String RESPONSE_CODE = "Dummy.responseCode";
    private static final String SUCCESS = "Dummy.Success";


    public void setLabel(String label) {
        setProperty(LABEL, label);
    }

    public void setResponseCode(String responseCode) {
        setProperty(RESPONSE_CODE, responseCode);
    }

    public void setSuccessful(boolean success) {
        setProperty(SUCCESS, success);

    }

    public void setResponseTime(int responseTime) {
        setProperty(RESPONSE_TIME_PROPERTY, responseTime);

    }

    public String getLabel() {
        return getPropertyAsString(LABEL, Strings.EMPTY);
    }

    public String getResponseCode() {
        return getPropertyAsString(RESPONSE_CODE, "200");
    }

    public Object getResponseTime() {
        return getPropertyAsInt(RESPONSE_TIME_PROPERTY, 1000);
    }

    public boolean getSuccessful() {
        return getPropertyAsBoolean(SUCCESS, true);
    }


    @Override
    public SampleResult sample(Entry entry) {
        SampleResult result = new SampleResult();
        result.setSampleLabel(getLabel());
        result.setResponseCode(getResponseCode());
        result.setSuccessful(getSuccessful());
        result.sampleStart();
        try {
            Thread.sleep((Long) getResponseTime());
        } catch (InterruptedException e) {
            result.setSuccessful(false);
            result.setResponseMessage(e.getMessage());
            //LOG.error("Error while sleep", e);
            Thread.currentThread().interrupt();
        }
        result.sampleEnd();
        return result;
    }

}
