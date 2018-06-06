package xmlUtil;

import xmlUtil.annotation.AliasName;
import xmlUtil.annotation.Ignore;
import xmlUtil.model.Xml;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;

public class XmlUtil {
    public static void main(String[] args) {
        Xml xml = new Xml("testAppid","testUrl","testBody","sign","");
        String s = toXml(xml,Xml.class);
        System.out.println(s);
    }

    public static String toXml(Xml xml,Class clazz){
        try {
            Document document = DocumentHelper.createDocument();
            //添加根节点
            Element root = document.addElement(clazz.getSimpleName().toLowerCase());
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                Object o = field.get(xml);
                if(o!=null){
                    //使用了ignore注解忽略
                    Ignore annotation = field.getAnnotation(Ignore.class);
                    if(annotation!=null){
                        continue;
                    }
                    String s = field.getGenericType().toString();
                    if(s.contains("String")){
                        if(!o.toString().equals("")){
                            AliasName aliasName = field.getAnnotation(AliasName.class);
                            if(aliasName==null){
                                root.addElement(field.getName()).setText(o.toString());
                                continue;
                            }
                            //设置别名
                            Element element = null;
                            if(aliasName.value().equals("")){
                                element = root.addElement(field.getName());
                            }else{
                                element = root.addElement(aliasName.value());
                            }

                            //更改xmltext
                            if(aliasName.isData()){
                                element.addCDATA(o.toString());
                            }else{
                                element.addText(o.toString());
                            }
                        }
                    }else{
                        root.addElement(field.getName()).setText(field.get(xml).toString());
                    }
                }
            }
            return document.getRootElement().asXML();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
