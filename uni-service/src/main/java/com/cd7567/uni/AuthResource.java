package com.cd7567.uni;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.auth.LoginConfig;

@Path("/auth")
@LoginConfig(authMethod = "KEYCLOAK")
@Authenticated
public class AuthResource {
    @Inject
    SecurityContext securityContext;

    @GET
    @Path("/login")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String login() {
        return "You are logged in as %s".formatted(securityContext.getUserPrincipal().getName());
    }

    @GET
    @Path("/success")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String successfulLogin() {
        return "Welcome onboard, %s!".formatted(securityContext.getUserPrincipal().getName());
    }
}
