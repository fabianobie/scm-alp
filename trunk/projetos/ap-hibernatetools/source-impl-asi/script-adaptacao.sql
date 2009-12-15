--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_estado_ide) mapped to different tables! previous: org.hibernate.mapping.Table(fornecedor_pf) current:org.hibernate.mapping.Table(motorista)
ALTER TABLE frotasweb.fornecedor_pf drop CONSTRAINT fk_estado_ide;
ALTER TABLE frotasweb.fornecedor_pf ADD CONSTRAINT fk_fornecedor_pf_estado_ide FOREIGN KEY(id_estado) REFERENCES frotasweb.estado(id_estado);

--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_situacao_cidade) mapped to different tables! previous: org.hibernate.mapping.Table(cidade) current:org.hibernate.mapping.Table(funcionario)
ALTER TABLE frotasweb.funcionario drop CONSTRAINT fk_situacao_cidade;
ALTER TABLE frotasweb.funcionario ADD CONSTRAINT fk_fornecedor_situacao_cidade FOREIGN KEY(ind_ativo) REFERENCES frotasweb.sim_nao(id_sim_nao);

--org.hibernate.cfg.JDBCBinderException: Foreign key name (fk_situacao_cidade) mapped to different tables! previous: org.hibernate.mapping.Table(cidade) current:org.hibernate.mapping.Table(localidade)
ALTER TABLE frotasweb.localidade drop CONSTRAINT fk_situacao_cidade;
ALTER TABLE frotasweb.localidade ADD CONSTRAINT fk_localidade_situacao_cidade FOREIGN KEY(ind_ativo) REFERENCES frotasweb.sim_nao(id_sim_nao);