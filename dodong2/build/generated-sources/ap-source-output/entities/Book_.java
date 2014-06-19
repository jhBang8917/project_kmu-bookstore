package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-18T20:41:20")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, Integer> sellPrice;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Integer> stock;
    public static volatile SingularAttribute<Book, Integer> boughtPrice;
    public static volatile SingularAttribute<Book, String> publisher;

}