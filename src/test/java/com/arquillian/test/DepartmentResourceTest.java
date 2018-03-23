package com.arquillian.test;

import com.arquillian.controller.rest.DepartmentService;
import com.arquillian.controller.rest.RestAppConfig;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@RunWith(Arquillian.class)
public class DepartmentResourceTest {

    public DepartmentResourceTest() {}

    @Deployment(testable = true)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "arquillian-demo-test.war")
                .addClasses(DepartmentService.class, RestAppConfig.class);
    }

    @Test
    @InSequence(1)
    public void testResource() {
        WebTarget target = ClientBuilder.newClient()
                .target("http://localhost:8080/arquillian-demo-test/webresources/departments/hello");

    }
}
