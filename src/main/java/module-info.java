module my.module {
    requires java.base;
    requires org.postgresql.jdbc;
    requires java.sql;
    requires java.naming;
    requires spring.data.commons;

    opens com.techatpark.practices;
}