package main.java.com.arco.phcsa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arco.phcsa.dominio.Edificio;
import com.arco.phcsa.servicios.ServicioEdificio;
import com.arco.phcsa.servicios.ServicioEdificioImpl;

import junit.framework.Test;
import junit.framework.TestResult;


public class ServicioEdificioTest implements Test {

	@Autowired ServicioEdificioImpl servicio;
	
	@Override
	public int countTestCases() {
		return 0;
	}

	@Override
	public void run(TestResult result) {
		
		Edificio edificio = servicio.findById(4);
		edificio.setDireccion("Nueva direccion");
		servicio.update(edificio);
	}
	
}
