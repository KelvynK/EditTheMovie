package com.video.startup.projetovideo.Models;


public class Empresa
{

    private int       id;
    private String    nome_curto;
    private String    razao_social;
    private String    email;
    private long      cnpj;
    private String    telefone;
    private String    login;
    private String    senha;
    private Endereco  endereco;


    public int getId()
    {
        return id;
    }

    public void setId(int pId)
    {
        id = pId;
    }


    public String getNome_Curto()
    {
        return nome_curto;
    }

    public void setNome_Curto(String pNome_Curto)
    {
        nome_curto = pNome_Curto;
    }


    public String getRazao_Social()
    {
        return razao_social;
    }

    public void setRazao_Social(String pRazao_Social)
    {
        razao_social = pRazao_Social;
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }


    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String pTelefone)
    {
        telefone = pTelefone;
    }


    public long getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(long pCnpj)
    {
        cnpj = pCnpj;
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

	public Endereco getEndereco() {
        return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	
}

