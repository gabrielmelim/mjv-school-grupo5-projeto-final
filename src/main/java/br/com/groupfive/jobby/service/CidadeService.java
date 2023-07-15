package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;
}
