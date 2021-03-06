package cn.com.deepdata.datacenter;

import cn.com.deepdata.datacenter.example.TemplateHealthCheck;
import cn.com.deepdata.datacenter.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DataCenterApplication extends Application<DataCenterConfiguration> {

    public static void main(String[] args) throws Exception {
        new DataCenterApplication().run(args);
    }

    @Override
    public String getName() {
        return "datacenter-api";
    }

    @Override
    public void initialize(Bootstrap<DataCenterConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DataCenterConfiguration configuration,
                    Environment environment) throws Exception {

        System.out.println("configuration" + configuration);
        System.out.println("configuration getDefaultName" + configuration.getDefaultName());
        System.out.println("configuration getTemplate" + configuration.getTemplate());

        final UserResource resource = new UserResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("tttt", healthCheck);
    }

}
