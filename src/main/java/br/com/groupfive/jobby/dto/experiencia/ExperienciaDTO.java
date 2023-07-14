package br.com.groupfive.jobby.dto.experiencia;

import br.com.groupfive.jobby.model.CadastroExperiencia;

import java.time.LocalDate;
import java.time.ZoneId;

public record ExperienciaDTO (
    Integer id,
    Double salario,
    Boolean empregoAtual,
    LocalDate dataContratacao,
    LocalDate dataDesligamento,
//    String regimeContratacao,
//    String nomeEmpresa,
    Integer idCadastro,
    Integer idProfissao
)
{
    public static ExperienciaDTO fromModel(CadastroExperiencia experiencia) {
        return new ExperienciaDTO(
            experiencia.getIdCadExperiencia(),
            experiencia.getSalario().doubleValue(),
            experiencia.isEmpregoAtual(),
            experiencia.getDataContratacao()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(),
            experiencia.getDataDesligamento()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(),
//            experiencia.getRegimeContratacao(),
//            experiencia.getNomeEmpresa(),
            experiencia.getCadastro().getIdCadastro(),
            experiencia.getProfissao().getIdProfissao()
        );
    }
}
