package com.dh.odontologica;

import com.dh.odontologica.model.Odontologo;
import com.dh.odontologica.persistence.dao.impl.OdontologoDAOH2;
import com.dh.odontologica.service.OdontologoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontologicaApplication.class, args);

//		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OdontologicaApplication.class);


//		OdontologoService odontologoService = new OdontologoService();  // Instancio OdontologoService
//		odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

		//********************************Crear un nuevo objeto (Registro) Odontologo**************************************************************//

//
//        Odontologo odontologo = new Odontologo(); //Instancio Odontologo
//
//        odontologo.setNombre("Ana Elvia");
//        odontologo.setApellido("Saavedra");
//        odontologo.setNumeroMatricula("81950425");
//        odontologoService.guardaOdontologoService(odontologo); // le paso por parametro la informacion creada en el objeto odontologo

		//****************Consultar Todos los registro de la base de datos tabla Odontologo*********************************************************//

		// Debe existir un metodo toString en el Odontologo

//            int ListarTodo = odontologoService.listarTodosServices().size();


//            for (int i=0; i< ListarTodo; i++) {
//                Odontologo registros = odontologoService.listarTodosServices().get(i);
////                logger.info(registros);
//            }

		//***************************************Consultar por un Solo ID tabla Odontologo***********************************************************//

//        logger.info(odontologoService.buscarOdontologoService(25));

		//****************************************Eliminar Registro por ID tabla Odontologo********************************************************//
//         odontologoService.eliminar(3L);

		//*****************************************************************************************************************************************//



	}

}
