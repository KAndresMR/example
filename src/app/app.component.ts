import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './services/user.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'example';
  error: string = ''; // Mensaje de error en caso de fallo
  usuarioData: any[] = []
  

  constructor(private userService: UserService) { }



  consultar(): void{ 
    this.userService.getUsuarioData().subscribe(
      (data) => {
        this.usuarioData = data; // Asignar los datos recibidos a la variable usuarioData
        console.log(data);
      },
      (error) => {
        this.error = 'Error al obtener los datos del usuario'; // Manejar el error
        console.error(error);
      }
    );

  }
}
