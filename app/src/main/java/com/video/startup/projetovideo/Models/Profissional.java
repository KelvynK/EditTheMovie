package com.video.startup.projetovideo.Models;

import java.util.Date;

public class Profissional 
{
    
    private int       id;
    private String    nome;
    private String    email;
    private long      cpf;
    private Date 	  nascimento;
    private String	  telefone;
    private String	  login;
    private String	  senha;
    private Endereco  endereco;


    public int getId()
    {
        return id;
    }

    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setId(int pId)
    {
        id = pId;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String pNome)
    {
        nome = pNome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public long getCpf()
    {
        return cpf;
    }

    public void setCpf(long pCpf)
    {
        cpf = pCpf;
    }

    public Date getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(Date pNascimento)
    {
        nascimento = pNascimento;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String pTelefone)
    {
        telefone = pTelefone;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String pLogin)
    {
        login = pLogin;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String pSenha)
    {
        senha = pSenha;
    }
    
    
}
