FROM jboss/wildfly
ADD wftest.server.ear/target/wftest.server-wftest.server.ear-1.31.0-buildr.ear /opt/jboss/wildfly/standalone/deployments/
