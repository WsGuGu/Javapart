package javase.net;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/6 11 24
 */
public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //从解析工厂获取解析器
        SAXParser parser=factory.newSAXParser();
        //编写处理器,并加载处理器
        PersonHandler handler=new PersonHandler();
        //解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("javase/net/p.xml"),handler);
        //获取数据
        List<Person> persons=handler.getPersons();
        for (Person p:persons){
            System.out.println("姓名"+p.getName()+"年龄"+p.getAge());
        }
    }
}
class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;//存储操作的标签
    @Override
    public void startDocument() throws SAXException {
        System.out.println("-------解析文档开始-------");
        persons=new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("-------解析文档结束-------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "---->解析开始 ");
        if (qName!=null){
            tag=qName;
        }
        if (tag.equals("person")){
            person=new Person();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "----->解析结束");
        if (qName!=null) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag=null;//tag丢弃掉
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag!=null){
            if (tag.equals("name")){
                person.setName(contents);
            }else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }
    public List<Person> getPersons() {
        return persons;
    }
}