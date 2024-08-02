import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // URL base de la API de usuarios
  apiUrl: string = "http://localhost:8080/ejemplo/api"; 

  constructor(private http: HttpClient) { }

  /**
   * Obtiene los datos de usuario a partir de la cédula.
   * 
   * @param cedula La cédula del usuario que se desea consultar.
   * @return Un Observable que emite los datos del usuario.
   */
  getUsuarioData(): Observable<any> {
    return this.http.get(`${this.apiUrl}/usuarios`); // Realiza una solicitud GET a la API
  }
}
