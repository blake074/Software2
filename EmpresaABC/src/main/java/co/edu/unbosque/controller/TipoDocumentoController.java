package co.edu.unbosque.controller;
import co.edu.unbosque.model.entities.TipoDocumento;
import co.edu.unbosque.model.repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @GetMapping("/lista")
    public List<TipoDocumento> obtenerDocumentos() {
        return tipoDocumentoRepository.findAll();
    }
}
