package com.mycompany.model;

import com.mycompany.model.Category;
import com.mycompany.model.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-08T11:59:47")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Integer> code;
    public static volatile SingularAttribute<Note, Person> person;
    public static volatile SingularAttribute<Note, Integer> rating;
    public static volatile SingularAttribute<Note, String> header;
    public static volatile SingularAttribute<Note, Date> dates;
    public static volatile SingularAttribute<Note, Category> category;
    public static volatile SingularAttribute<Note, String> body;
    public static volatile SingularAttribute<Note, String> commentary;

}