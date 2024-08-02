package ec.edu.ups.ejemplo.services;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
public class CORSFilter implements ContainerResponseFilter{

	@Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); // Permite el acceso desde cualquier origen
        responseContext.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, access-control-allow-origin, Referrer-Policy"); // Define los encabezados permitidos en la solicitud
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true"); // Permite el uso de credenciales (como cookies) en solicitudes CORS
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD"); // Define los métodos HTTP permitidos

        responseContext.getHeaders().add("Access-Control-Max-Age", "1209600"); // Establece el tiempo (en segundos) durante el cual la respuesta CORS puede ser almacenada en caché
    }
}
