package com.example.andy;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {

    private String nodeName;

    private StringBuilder addr;

    private StringBuilder appointMan;

    private StringBuilder createTime;

    private StringBuilder endTime;

    @Override
    public void startDocument() throws SAXException {
        addr = new StringBuilder();
        appointMan = new StringBuilder();
        createTime = new StringBuilder();
        endTime = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 记录当前结点名
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 根据当前的结点名判断将内容添加到哪一个StringBuilder对象中
        if ("addr".equals(nodeName)) {
            addr.append(ch, start, length);
        } else if ("appointMan".equals(nodeName)) {
            appointMan.append(ch, start, length);
        } else if ("createTime".equals(nodeName)) {
            createTime.append(ch, start, length);
        }else if ("endTime".equals(nodeName)) {
            endTime.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(localName)) {
            Log.d("ContentHandler", "addr is " + addr.toString().trim());
            Log.d("ContentHandler", "appointMan is " + appointMan.toString().trim());
            Log.d("ContentHandler", "createTime is " +  createTime.toString().trim());
            Log.d("ContentHandler", "endTime is " +  endTime.toString().trim());
            // 最后要将StringBuilder清空掉
            addr.setLength(0);
            appointMan.setLength(0);
            createTime.setLength(0);
            endTime.setLength(0);

        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

}
