package com.codescan.admin;

import cn.hutool.core.io.resource.ResourceUtil;
import org.junit.Test;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class JythonTest {

    @Test
    public void test001(){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'");
        interpreter.exec("print a;");
    }

    @Test
    public void test002(){
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        try {
            String filename = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "python-script/javaPythonFile.py").getPath();
//            System.out.println(filename);
            pythonInterpreter.execfile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test003(){
        try {
            String filename = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "python-script/javaPythonFile.py").getPath();
            Process process = Runtime.getRuntime().exec("python " +filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            process.waitFor();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test004(){
        PythonInterpreter interpreter = new PythonInterpreter();
        try {
            String filename = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "python-script/add.py").getPath();
            interpreter.execfile(filename);
            PyFunction pyFunction = interpreter.get("add",PyFunction.class);
            int a = 5, b = 10;
            PyObject pyObject = pyFunction.__call__(new PyInteger(a),new PyInteger(b));
            System.out.println("the answer is:" + pyObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
