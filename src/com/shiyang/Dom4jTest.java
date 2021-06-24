package com.shiyang;

import  org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;

/**
 * @author shiyang
 * @date  2021/6/10
 */
public class Dom4jTest {
    public static void main(String[] args) {

    }

    public static Document load(String filename) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }

    public static Document load(URL url) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(url); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }
}
