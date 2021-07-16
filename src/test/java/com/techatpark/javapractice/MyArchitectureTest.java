package com.techatpark.javapractice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


class MyArchitectureTest {

    @Test
     void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.techatpark.javapractice");
//        ArchRule rule = layeredArchitecture()
//                .layer("Controller").definedBy("..controller..")
//                .layer("Service").definedBy("..services..")
//                .layer("Persistence").definedBy("..repository..")
//                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
//                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
//                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");
//        rule.check(importedClasses);



        ArchRule sql_should_be_in_repository =  classes().that().belongToAnyOf(Connection.class, Statement.class, PreparedStatement.class)
                .should().onlyBeAccessed().byClassesThat().resideInAPackage("..repository..");
//                resideInAnyPackage("..repository..").should().on(Connection.class, Statement.class, PreparedStatement.class).because("Jdbc classes should be used only in persistence layer");
        sql_should_be_in_repository.check(importedClasses);
    }
}
