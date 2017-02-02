package com.sfeir.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;
import spoon.reflect.code.CtCodeSnippetStatement;

/**
 * Created by bcornu on 2/2/17.
 */
public class MyFirstProcessor extends AbstractProcessor<CtCatch> {

    public void process(CtCatch element) {
        if (element.getBody().getStatements().size() == 0) {
            CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
            snippet.setValue(element.getParameter().getSimpleName()+".printStackTrace()");
            element.getBody().addStatement(snippet);
        }
    }

}