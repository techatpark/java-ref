module my.module {
    requires java.base;
    requires org.postgresql.jdbc;
    requires java.sql;
    requires java.naming;

    opens com.techatpark.practices;
}