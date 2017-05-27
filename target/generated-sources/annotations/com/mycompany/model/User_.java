package com.mycompany.model;

import com.mycompany.model.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-26T19:25:55")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> pass;
    public static volatile SingularAttribute<User, Short> state;
    public static volatile SingularAttribute<User, String> type;
    public static volatile SingularAttribute<User, String> user;
    public static volatile SingularAttribute<User, Person> codeU;

}