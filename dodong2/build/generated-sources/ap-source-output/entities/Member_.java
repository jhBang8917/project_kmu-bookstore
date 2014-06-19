package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-18T20:41:20")
@StaticMetamodel(Member.class)
public class Member_ { 

    public static volatile SingularAttribute<Member, Long> id;
    public static volatile SingularAttribute<Member, String> userID;
    public static volatile SingularAttribute<Member, String> name;
    public static volatile SingularAttribute<Member, String> password;

}