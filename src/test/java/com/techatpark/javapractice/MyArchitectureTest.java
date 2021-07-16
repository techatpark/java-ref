package com.techatpark.javapractice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@ArchTag("basic")
@AnalyzeClasses(packages = "com.techatpark")
class MyArchitectureTest {

    @ArchTest
    private final ArchRule no_access_to_jdbc = noClasses().should().accessClassesThat()
            .belongToAnyOf(Connection.class, Statement.class, PreparedStatement.class)
            .because("we do not use JDBC directly");

    @Test
     void some_architecture_rule() {


        JavaClasses importedClasses = new ClassFileImporter()
                .importPackages("com.techatpark");

//        ArchRule rule = layeredArchitecture()
//                .layer("Controller").definedBy("..controller..")
//                .layer("Service").definedBy("..services..")
//                .layer("Persistence").definedBy("..repository..")
//                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
//                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
//                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");
//        rule.check(importedClasses);



        no_access_to_jdbc.check(importedClasses);
    }
}
