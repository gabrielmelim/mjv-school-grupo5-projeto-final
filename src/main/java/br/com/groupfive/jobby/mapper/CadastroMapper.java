package br.com.groupfive.jobby.mapper;

import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import br.com.groupfive.jobby.model.*;

public class CadastroMapper {

    public static Cadastro fromCreateCadastroDTOToEntity(
        CreateCadastroDTO createCadastroDTO,
        Endereco endereco,
        Profissao profissao
    ) {
        Cadastro cadastro = new Cadastro();
        PretencaoSalarial pretencaoSalarial = new PretencaoSalarial();
        Celular celularPessoal = new Celular();
        Celular celularProfissional = new Celular();
        cadastro.setNome(createCadastroDTO.nome());
        cadastro.setCpf(createCadastroDTO.cpf());
        cadastro.setDataNascimento(createCadastroDTO.dataNascimento());
        cadastro.setTelefone(createCadastroDTO.telefone());
        cadastro.setEmail(createCadastroDTO.email());
        cadastro.setSexo(Sexo.valueOf(createCadastroDTO.sexo()));
        pretencaoSalarial.setValorMinimo(createCadastroDTO.pretensaoMin());
        pretencaoSalarial.setValorMaximo(createCadastroDTO.pretensaoMax());
        cadastro.setPretencaoSalarial(pretencaoSalarial);
        celularPessoal.setWhatsapp(createCadastroDTO.isWhatsPessoal());
        celularPessoal.setNumero(createCadastroDTO.numeroCelularPessoal());
        cadastro.setCelularPessoal(celularPessoal);
        celularProfissional.setWhatsapp(createCadastroDTO.isWhatsProfissional());
        celularProfissional.setNumero(createCadastroDTO.numeroCelularProfissional());
        cadastro.setCelularProfissional(celularProfissional);
        cadastro.setProfissao(profissao);
        cadastro.setHabilidades(createCadastroDTO.habilidades());
        cadastro.setEndereco(endereco);
        return cadastro;
    }

    public static void fromUpdateCadastroDTOToEntity(
            Cadastro cadastro,
            UpdateCadastroDTO updateCadastroDTO,
            Endereco endereco,
            Profissao profissao
    ) {
        PretencaoSalarial pretencaoSalarial = new PretencaoSalarial();
        Celular celularPessoal = new Celular();
        Celular celularProfissional = new Celular();
        cadastro.setNome(updateCadastroDTO.nome());
        cadastro.setCpf(updateCadastroDTO.cpf());
        cadastro.setDataNascimento(updateCadastroDTO.dataNascimento());
        cadastro.setTelefone(updateCadastroDTO.telefone());
        cadastro.setEmail(updateCadastroDTO.email());
        cadastro.setSexo(Sexo.valueOf(updateCadastroDTO.sexo()));
        pretencaoSalarial.setValorMinimo(updateCadastroDTO.pretensaoMin());
        pretencaoSalarial.setValorMaximo(updateCadastroDTO.pretensaoMax());
        cadastro.setPretencaoSalarial(pretencaoSalarial);
        celularPessoal.setWhatsapp(updateCadastroDTO.isWhatsPessoal());
        celularPessoal.setNumero(updateCadastroDTO.numeroCelularPessoal());
        cadastro.setCelularPessoal(celularPessoal);
        celularProfissional.setWhatsapp(updateCadastroDTO.isWhatsProfissional());
        celularProfissional.setNumero(updateCadastroDTO.numeroCelularProfissional());
        cadastro.setCelularProfissional(celularProfissional);
        cadastro.setProfissao(profissao);
        cadastro.setEndereco(endereco);
    }
}