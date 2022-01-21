package com.clibanez.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clibanez.helpdesk.domain.Chamado;
import com.clibanez.helpdesk.domain.Cliente;
import com.clibanez.helpdesk.domain.Tecnico;
import com.clibanez.helpdesk.domain.enums.Perfil;
import com.clibanez.helpdesk.domain.enums.Prioridade;
import com.clibanez.helpdesk.domain.enums.Status;
import com.clibanez.helpdesk.repositories.ChamadoRepository;
import com.clibanez.helpdesk.repositories.ClienteRepository;
import com.clibanez.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	
		
		@Autowired
		private TecnicoRepository tecnicoRepository;
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private ChamadoRepository chamadoRepository;
		
		public void  instanciaDB() {
			
			Tecnico tec1 = new Tecnico(null, "Clibanez Caldas", "183.117.420-06", "clibanez@gmail.com","12334");
			tec1.addPerfil(Perfil.ADMIN);
			Tecnico tec2 = new Tecnico(null, "Maria de Fatima", "715.761.480-41", "maria@gmail.com","12334");
			
			Cliente cli1 = new Cliente(null, "Matheus Calebe", "635.361.570-17", "Matheus@gmail.com", "1223");
			
			Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "Primeiro chmado", tec1, cli1);
			
			tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
			clienteRepository.saveAll(Arrays.asList(cli1));
			chamadoRepository.saveAll(Arrays.asList(c1));
			
		
		
	}

}
