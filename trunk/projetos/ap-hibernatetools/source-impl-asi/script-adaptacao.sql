--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_estado_ide) mapped to different tables! previous: org.hibernate.mapping.Table(fornecedor_pf) current:org.hibernate.mapping.Table(motorista)
ALTER TABLE frotasweb.fornecedor_pf drop CONSTRAINT fk_estado_ide;
ALTER TABLE frotasweb.fornecedor_pf ADD CONSTRAINT fk_fornecedor_pf_estado_ide FOREIGN KEY(id_estado) REFERENCES frotasweb.estado(id_estado);

--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_situacao_cidade) mapped to different tables! previous: org.hibernate.mapping.Table(cidade) current:org.hibernate.mapping.Table(funcionario)
ALTER TABLE frotasweb.funcionario drop CONSTRAINT fk_situacao_cidade;
ALTER TABLE frotasweb.funcionario ADD CONSTRAINT fk_fornecedor_situacao_cidade FOREIGN KEY(ind_ativo) REFERENCES frotasweb.sim_nao(id_sim_nao);

--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_situacao_cidade) mapped to different tables! previous: org.hibernate.mapping.Table(cidade) current:org.hibernate.mapping.Table(localidade)
ALTER TABLE frotasweb.localidade drop CONSTRAINT fk_situacao_cidade;
ALTER TABLE frotasweb.localidade ADD CONSTRAINT fk_localidade_situacao_cidade FOREIGN KEY(ind_ativo) REFERENCES frotasweb.sim_nao(id_sim_nao);

HBM'S >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Onde o estado do component Identidade foi comentado:
FornecedorPF.hbm.xml
Responsavel.hbm.xml
Motorista.hbm.xml

Mudei o sequence class de native para sequence em todos os hbm's.

O CustomAuditoria tem mais um monte de atributos que não foram gerados, as vezes o hbm não está atualizado com a Entidade atual.

alteradas depois de finalizado
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/CaracteristicaVeiculo.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/Material.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/MarcaVeiculo.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/Veiculo.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/Parcela.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/UnidadeMedida.java
    U  C:/java/projetos/entities/src/main/java/br/com/linkdata/entity/UnidadeOrganizacional.java