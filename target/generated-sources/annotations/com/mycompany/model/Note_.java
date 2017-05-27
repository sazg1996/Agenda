package com.mycompany.model;

import com.mycompany.model.Category;
import com.mycompany.model.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-26T19:25:55")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Date> date;
    public static volatile SingularAttribute<Note, Integer> code;
    public static volatile SingularAttribute<Note, Person> person;
    public static volatile SingularAttribute<Note, Category> categoria;
    public static volatile SingularAttribute<Note, String> rating;
    public static volatile SingularAttribute<Note, String> header;
    public static volatile SingularAttribute<Note, String> body;
    public static volatile SingularAttribute<Note, String> commentary;

}