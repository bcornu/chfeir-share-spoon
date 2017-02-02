package com.sfeir.processors;

import org.apache.log4j.Level;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;

/**
 * Created by bcornu on 2/2/17.
 */
public class MyFirstAnalyzer extends AbstractProcessor<CtCatch> {

    public void process(CtCatch element) {
        if (element.getBody().getStatements().size() == 0) {
            getFactory().getEnvironment().report(this, Level.ERROR, element, "empty catch clause");
        }
    }

}