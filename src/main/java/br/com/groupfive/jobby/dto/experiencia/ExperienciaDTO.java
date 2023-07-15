package br.com.groupfive.jobby.dto.experiencia;

import br.com.groupfive.jobby.model.Experiencia;

import java.time.LocalDate;

public record ExperienciaDTO (
    Integer id,
    Double salario,
    Boolean empregoAtual,
    LocalDate dataContratacao,
    LocalDate dataDesligamento,
    String regimeContratacao,
    String nomeEmpresa,
    Integer idCadastro,
    Integer idProfissao
)
{
    public static ExperienciaDTO fromModel(Experiencia experiencia) {
        return new ExperienciaDTO(
            experiencia.getIdCadExperiencia(),
            experiencia.getSalario().doubleValue(),
            experiencia.isEmpregoAtual(),
            experiencia.getDataContratacao(),
            experiencia.getDataDesligamento(),
            experiencia.getRegimeContratacao().name(),
            experiencia.getNomeEmpresa(),
            experiencia.getCadastro().getIdCadastro(),
            experiencia.getProfissao().getIdProfissao()
        );
    }
}
