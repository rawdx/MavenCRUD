package clase.MavenCRUD.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clase.MavenCRUD.dtos.LibroDto;

public class ConversionDto {
	
public void ConvertirADto(ResultSet resultadoConsulta, ArrayList<LibroDto> listaLibros){	
		try {
			while (resultadoConsulta.next()) {
				listaLibros.add(new LibroDto(resultadoConsulta.getLong("id_libro"),
						resultadoConsulta.getString("titulo"),
						resultadoConsulta.getString("autor"),
						resultadoConsulta.getString("isbn")));
			}
		} catch (SQLException e) {
			System.out.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de LibroDto" + e);
		}
	}
}
