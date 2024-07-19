module my.module {
    requires java.base;
    requires mysql.connector.j;
    requires java.sql;
    requires java.naming;
    requires spring.data.commons;

    opens com.techatpark.practices;
}