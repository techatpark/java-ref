module my.module {
    requires java.base;
    requires org.jsoup;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.techatpark.gurukulams;
}