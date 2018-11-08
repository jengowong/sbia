package com.github.jengo.annotationprocessing;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * http://hannesdorfmann.com/annotation-processing/annotationprocessing101
 */
public class MyProcessor extends AbstractProcessor {

    /**
     * Every annotation processor class must have an empty constructor.
     * However, there is a special init() method which is invoked by the annotation processing tool with the ProcessingEnvironment as parameter.
     * The ProcessingEnvironment provides some useful util classes Elements, Types and Filer.
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    /**
     * This is kind of main() method of each processor.
     * Here you write your code for scanning, evaluating and processing annotations and generating java files.
     * With RoundEnvironment passed as parameter you can query for elements annotated with a certain annotation.
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    /**
     * Used to specify for which annotations this annotation processor should be registered for.
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    /**
     * Used to specify which java version you use.
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
