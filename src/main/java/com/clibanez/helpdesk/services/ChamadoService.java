package com.clibanez.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.helpdesk.domain.Chamado;
import com.clibanez.helpdesk.domain.Cliente;
import com.clibanez.helpdesk.domain.Tecnico;
import com.clibanez.helpdesk.domain.dtos.ChamadoDTO;
import com.clibanez.helpdesk.domain.enums.Prioridade;
import com.clibanez.helpdesk.domain.enums.Status;
import com.clibanez.helpdesk.repositories.ChamadoRepository;
import com.clibanez.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	public Chamado findById(Integer id) {	
		Optional <Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}
	
	 public List<Chamado> findAll(){
	        return chamadoRepository.findAll();
	    }
	 
	 public Chamado create(@Valid ChamadoDTO objDTO) {
		 return chamadoRepository.save(newChamado(objDTO));
	 }
	 
	 private Chamado newChamado(ChamadoDTO obj) {
		 Tecnico tecnico =  tecnicoService.findById(obj.getTecnico());
		 Cliente cliente =  clienteService.findById(obj.getCliente());
		 
		 Chamado chamado = new Chamado();
		 if(obj.getId() != null) {
			 chamado.setId((obj.getId()));
		 }
		 
		 chamado.setTecnico(tecnico);
		 chamado.setCliente(cliente);
		 chamado.setPrioridade((Prioridade.toEnum((obj.getPrioridade()))));
		 chamado.setStatus(Status.toEnum(obj.getStatus()));
		 chamado.setTitulo(obj.getTitulo());
		 chamado.setObservacoes(obj.getObservacoes());
		 return chamado;
	 }
	 
	 
	
	

}
