package com.pragmatic.jmeter.plugin.dummy.sampler.gui;

import com.pragmatic.jmeter.plugin.dummy.sampler.DummySampler;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pragmatic Test Labs (Private) Limited
 *
 * @Author Janesh Kodikara
 */
public class DummySamplerGui extends AbstractSamplerGui {

    private final JTextField responseTime = new JTextField();
    private final JTextField label = new JTextField();
    private final JTextField responseCode = new JTextField();
    private final JCheckBox success = new JCheckBox("Success", true);

    public DummySamplerGui() {
        setLayout(new BorderLayout());
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
        add(createDummySamplerPanel(), BorderLayout.CENTER);
    }

    private Component createDummySamplerPanel() {
        return null;
    }

    @Override
    public String getLabelResource() {
        return "PTL Dummy Sample";
    }

    @Override
    public TestElement createTestElement() {
        DummySampler dummySampler = new DummySampler();
        configureTestElement(dummySampler);
        return dummySampler;
    }

    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);
        if (element instanceof DummySampler) {
            DummySampler dummySampler = (DummySampler) element;
            dummySampler.setLabel(label.getText());
            dummySampler.setResponseCode(responseCode.getText());
            dummySampler.setSuccessful(success.isSelected());
            try {
                int responseTime = Integer.parseInt(this.responseTime.getText());
                dummySampler.setResponseTime(responseTime);
            } catch (NumberFormatException e) {
                //LOG.error("Response time must be Integer", e);
            }
        }

    }

    @Override
    public String getStaticLabel() {
        return getLabelResource();
    }


    @Override
    public void configure(TestElement element) {
        super.configure(element);
        if (element instanceof DummySampler) {
            DummySampler dummySampler = (DummySampler) element;
            label.setText(dummySampler.getLabel());
            responseCode.setText(dummySampler.getResponseCode());
            responseTime.setText(dummySampler.getResponseTime().toString());
            success.setSelected(dummySampler.getSuccessful());
        }
    }

    @Override
    public void clearGui() {
        super.clearGui();
        label.setText("");
        responseTime.setText("1000");
        responseCode.setText("");
        success.setSelected(true);
    }


}
