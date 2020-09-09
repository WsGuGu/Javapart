package javabasic.net;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/4 17 22
 */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //从解析工厂获取解析器
        SAXParser parser=factory.newSAXParser();
        //编写处理器,并加载处理器
        PHandler handler=new PHandler();
        //解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("javabasic/net/p.xml"),handler);
    }
}
class PHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("-------解析文档开始-------");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("-------解析文档结束-------");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"---->解析开始 ");
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"----->解析结束");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents=new String(ch,start,length).trim();
        if (contents.length()>0) {
            System.out.println("内容为" + contents);
        } else {
            System.out.println("内容为->"+"空");
        }
    }
}