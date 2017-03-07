package javassist;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

/**
 * Created by rembau on 2017/3/2.
 */
public class JavassistTest {

    @Test
    public  void changeClass() throws Exception {

        //System.out.println(new Student().getAge());

        ClassPool pool = ClassPool.getDefault();
        //获取一个Student类的CtClass对象
        CtClass ctClass = pool.get("javassist.Student");

        //为ctClass设置一个父类
        ctClass.setSuperclass(pool.get("javassist.Person"));
        //为cTclass对象添加一个属性name
        ctClass.addField(CtField.make("private String name;", ctClass));
        ctClass.addMethod(CtMethod.make("public void setName(String name){this.name = name;}", ctClass));
        ctClass.addMethod(CtMethod.make("public String getName(){return this.name;}", ctClass));

        //获取ctClass对象对应的Class对象student
        //Class student = ctClass.toClass();

//        try {
//            HotSwapper hotSwapper = new HotSwapper(40002);
//            hotSwapper.reload(Student.class.getName(), ctClass.toBytecode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ctClass.toClass();
        Class student = Student.class;

        //对student类进行内省，得到对象BeanInfo
        BeanInfo beanInfo = Introspector.getBeanInfo(student, Object.class);
        //获取beanInfo的方法描述对象
        MethodDescriptor[] descriptors = beanInfo.getMethodDescriptors();

        for (int i = 0; i < descriptors.length; i++) {
            System.out.println(descriptors[i].getName());
        }
        System.out.println(descriptors.length);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            System.out.println(propertyDescriptors[i].getDisplayName());
        }
    }
}
