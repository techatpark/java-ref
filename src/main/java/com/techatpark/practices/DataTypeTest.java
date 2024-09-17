package com.techatpark.practices;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;

public class DataTypeTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        //  Pre Reg: TABLE CREATED

        //  1. Generating Code Create Code Here
        File sourceFile = generateCode();

        // 2 Created Code should be Compiled at RUNTIME
        compileCode(sourceFile);

        // 3
        Class<?> myTableClass = loadCode(sourceFile);

        // 4
        runCode(myTableClass);

    }



















    static File generateCode() throws IOException {
        File  sourceFile = new File(System.getProperty("java.io.tmpdir") + File.separator + "MyTable.java");

        Files.writeString(sourceFile.toPath(), """
                public class MyTable {
                    public String getMyValue() {
                        return "This is my Value";
                    }
                }
                """);

        return sourceFile;
    }


















    static void compileCode(File  sourceFile) {

        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> ds = new DiagnosticCollector<>();

        try (StandardJavaFileManager mgr = compiler.getStandardFileManager(ds, null, null)) {
            Iterable<? extends JavaFileObject> sources = mgr.getJavaFileObjectsFromFiles(Collections.singletonList(sourceFile));
            javax.tools.JavaCompiler.CompilationTask task = compiler.getTask(null, mgr, ds, null, null, sources);
            task.call();
            for( final Diagnostic< ? extends JavaFileObject > diagnostic:
                    ds.getDiagnostics() ) {
                System.out.format("%s, line %d in %s",
                        diagnostic.getMessage( null ),
                        diagnostic.getLineNumber(),
                        diagnostic.getSource().getName() );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    private static Class loadCode(File  sourceFile) throws MalformedURLException, ClassNotFoundException {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(sourceFile.getParent()).toURI().toURL()});
        return classLoader.loadClass("MyTable");
    }



















    private static void runCode(Class<?> myTableClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object myTableObj = myTableClass.getConstructor().newInstance();
        Method getMethod = myTableClass.getMethod("getMyValue");
        System.out.println(getMethod.invoke(myTableObj));
    }






}
