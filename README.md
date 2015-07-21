# Wildfly Issue Repro

This repo is supposed to demonstrate our current issues with Wildfly. 
There is one web project which uses the first EJB project wich in turn uses the second EJB project.

## Current Problem

Having to EJB projects, each with its respective persistence.xml does not work. Even if they are not used! Persistence-Unit names are different.

This is the error Wildfly produces:
```
...
11:51:12,805 DEBUG [org.hibernate.jpa.internal.EntityManagerFactoryRegistry] (ServerService Thread Pool -- 63) Initializing EntityManagerFactoryRegistry : org.hibernate.jpa.internal.EntityManagerFactoryRegistry@265f9159
11:51:12,806 DEBUG [org.hibernate.jpa.internal.EntityManagerFactoryRegistry] (ServerService Thread Pool -- 63) Registering EntityManagerFactory: com.car2go.server.ear/wftest.server.acre.jar#HW30VserverACREUR
11:51:12,806 DEBUG [org.hibernate.jpa.internal.EntityManagerFactoryRegistry] (ServerService Thread Pool -- 65) Registering EntityManagerFactory: com.car2go.server.ear/wftest.server.acre.jar#HW30VserverACRE
11:51:12,815 ERROR [org.jboss.as.controller.management-operation] (Controller Boot Thread) WFLYCTL0013: Operation ("deploy") failed - address: ([("deployment" => "com.car2go.server.ear")]) - failure description: {"WFLYCTL0180: Services with missing/unavailable dependencies" => [
    "jboss.deployment.unit.\"com.car2go.server.ear\".deploymentCompleteService is missing [jboss.deployment.subunit.\"com.car2go.server.ear\".\"wftest.server.ejb.jar\".deploymentCompleteService, jboss.deployment.subunit.\"com.car2go.server.ear\".\"wftest.server.backend.web.war\".deploymentCompleteService]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.ORB is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.ValidatorFactory is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]",
    "jboss.deployment.subunit.\"com.car2go.server.ear\".\"wftest.server.acre.jar\".component.StationService.START is missing [jboss.persistenceunit.\"com.car2go.server.ear/wftest.server.ejb.jar#HW30Vserver\", jboss.persistenceunit.\"com.car2go.server.ear/wftest.server.ejb.jar#HW30VserverUR\"]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.HandleDelegate is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.InAppClientContainer is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.InstanceName is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]",
    "jboss.deployment.subunit.\"com.car2go.server.ear\".\"wftest.server.backend.web.war\".INSTALL is missing [jboss.deployment.subunit.\"com.car2go.server.ear\".\"wftest.server.ejb.jar\".deploymentCompleteService]",
    "jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService.Validator is missing [jboss.naming.context.java.comp.\"wftest.server.ear\".\"wftest.server.ejb\".ACREService]"
]}
...
11:51:12,909 INFO  [org.jboss.as.controller] (Controller Boot Thread) WFLYCTL0183: Service status report
WFLYCTL0184:    New missing/unsatisfied dependencies:
      service jboss.deployment.subunit."com.car2go.server.ear"."wftest.server.backend.web.war".deploymentCompleteService (missing) dependents: [service jboss.deployment.unit."com.car2go.server.ear".deploymentCompleteService]
      service jboss.deployment.subunit."com.car2go.server.ear"."wftest.server.ejb.jar".deploymentCompleteService (missing) dependents: [service jboss.deployment.unit."com.car2go.server.ear".deploymentCompleteService, service jboss.deployment.subunit."com.car2go.server.ear"."wftest.server.backend.web.war".INSTALL]
      service jboss.naming.context.java.comp."wftest.server.ear"."wftest.server.ejb".ACREService (missing) dependents: [service jboss.naming.context.java.comp."wftest.server.ear"."wftest.server.ejb".ACREService.Validator, service jboss.naming.context.java.comp."wftest.server.ear"."wftest.server.ejb".ACREService.InstanceName, service jboss.naming.context.java.comp."wftest.server.ear"."wftest.server.ejb".ACREService.ORB, service jboss.naming.context.java.comp."wftest.server.ear"."wftest.server.ejb".ACREService.ValidatorFactory, WFLYCTL0208: ... and 3 more ]
      service jboss.persistenceunit."com.car2go.server.ear/wftest.server.ejb.jar#HW30Vserver" (missing) dependents: [service jboss.deployment.subunit."com.car2go.server.ear"."wftest.server.acre.jar".component.StationService.START]
      service jboss.persistenceunit."com.car2go.server.ear/wftest.server.ejb.jar#HW30VserverUR" (missing) dependents: [service jboss.deployment.subunit."com.car2go.server.ear"."wftest.server.acre.jar".component.StationService.START]
...
```

