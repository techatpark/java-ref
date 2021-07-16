package com.techatpark.javapractice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


class MyArchitectureTest {

    @Test
     void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.techatpark.javapractice");
        ArchRule rule = layeredArchitecture()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..services..")
                .layer("Persistence").definedBy("..repository..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");
        //rule.check(importedClasses);

        ArchRule sql_shouldbe_in_repository =   classes().that().resideOutsideOfPackage("..repsitory..").should().accessClassesThat()
                .doNotBelongToAnyOf(Connection.class, Statement.class, PreparedStatement.class).because("Jdbc classes should be used only in persistence layer");
        sql_shouldbe_in_repository.check(importedClasses);
    }
}
