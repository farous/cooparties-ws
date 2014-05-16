package fr.cooparties.ws.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.cooparties.dao.SupportRepository;
import fr.cooparties.dao.TypeJeuRepository;
import fr.cooparties.domain.Support;
import fr.cooparties.domain.TypeJeu;
import fr.cooparties.ws.JeuxWs;

@Service
public class JeuxWsImpl implements JeuxWs {

	@Resource
	private TypeJeuRepository typeJeuRepository;

	@Resource
	private SupportRepository supportRepository;

	@Override
	public List<TypeJeu> getTypesJeux() {
		List<TypeJeu> typesJeux = typeJeuRepository.findAll();
		return typesJeux;
	}

	@Override
	public List<Support> getSupports() {
		List<Support> supports = supportRepository.findAll();
		return supports;
	}
}
