package cn.com.deepdata.datacenter.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.com.deepdata.datacenter.api.Saying;

import cn.com.deepdata.datacenter.entity.User;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/userservice/v1")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final AtomicLong counter;
    private final String template;
    private final String defaultName;

    public UserResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Response say(List<User> users) {

        System.out.println("Arrays.toString(users) = " + users);

        return Response.status(Response.Status.OK).build();


    }

    /**
     * show the usage of returning a bean, which will be converted to json by jersey
     * @param name
     * @return
     */
    @GET
    @Timed
    @Path("/say_hello")
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    /**
     * Receive a json array and deserialize as a list of java beans.
     * This method can be used for batch operations
     */
    @POST
    @Timed
    @Path("/users")
    public List<User> recordSentRisk(List<User> users) {

        System.out.println("Arrays.toString(users) = " + users);

        return users;


    }

}
