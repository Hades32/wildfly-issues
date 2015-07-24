FROM jboss/wildfly
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD wftest.server.ear/target/*.ear /opt/jboss/wildfly/standalone/deployments/
