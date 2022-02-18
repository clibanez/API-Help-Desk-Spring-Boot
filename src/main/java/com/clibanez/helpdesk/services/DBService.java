package com.clibanez.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		
		@Autowired
		private BCryptPasswordEncoder encoder;
		
		public void  instanciaDB() {

			Tecnico tec1 = new Tecnico(null, "Carlos", "183.117.420-06", "test@gmail.com", encoder.encode("123"));
			tec1.addPerfil(Perfil.ADMIN);
			Tecnico tec2 = new Tecnico(null, "Maria Rita", "715.761.480-41", "maria@gmail.com", encoder.encode("123"));
			
			Cliente cli1 = new Cliente(null, "Paulo Daniel", "635.361.570-17", "Matheus@gmail.com", encoder.encode("123"));
			Cliente cli2 = new Cliente(null, "Mario", "339.282.510-74", "cliente@gmail.com", encoder.encode("123"));
			tec1.addPerfil(Perfil.ADMIN);
			
			Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "Primeiro chmado", tec1, cli1);
			Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "Primeiro chmado", tec2, cli2);
			
			tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
			clienteRepository.saveAll(Arrays.asList(cli1,cli2));
			chamadoRepository.saveAll(Arrays.asList(c1,c2));
			
		
		
	}

}
