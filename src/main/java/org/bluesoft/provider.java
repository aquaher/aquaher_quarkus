package org.bluesoft;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.vertx.ext.web.Router;

@ApplicationScoped
public class provider {
    public void init(@Observes Router router) {
        router.errorHandler(404, routingContext -> {
            routingContext.response().setStatusCode(302).putHeader("Location", "/").end();
        });
}
}
