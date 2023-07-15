package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissaoService {
    @Autowired
    ProfissaoRepository profissaoRepository;
}
