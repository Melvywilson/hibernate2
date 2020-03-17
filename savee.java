package hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class save {
public static void main(String[] args)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
/*SessionFactory factory=cfg.buildSessionFactory();
Session session=factory.openSession();
product p=new product();
p.setProductId(101);
p.setProName("iPhone");
p.setPrice(25000);
Transaction tx=session.beginTransaction();
session.save(p);
System.out.println("Object saved successfully...");
tx.commit();
session.close();
factory.close();*/
	//to select data from database
SessionFactory factory=cfg.buildSessionFactory();
Session session=factory.openSession();
product p=new product();
Object o=session.load(product.class,new Integer(101));
product s=(product)o;
//for loading transactions scope is not necessary....
System.out.println("Loaded object product name is"+s.getProName());
Transaction tx=session.beginTransaction();
session.save(p);
System.out.println("Object saved successfully...");
tx.commit();
session.close();
factory.close();
}
}
