package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Dao.ContatoDao;
import entidades.Contato;

@ManagedBean
public class ContatoBean {
	
	private Contato contato = new Contato();
	private List<Contato> contatos ;
	
	public String  salvar() {
		ContatoDao.salvar(contato);
		contato = new Contato();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro Salvo com sucesso!"));
		return null;
	}
	
	public String editar() {
		ContatoDao.editar(contato);
		contato = new Contato();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Cadastro editado com sucesso!"));
				
		return null;
	}
	
	public String excluir() {
		try {
		ContatoDao.excluir(contato);
		contatos.remove(contato);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Cadastro Excluido com sucesso!"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Erro", "Erro ao Excluir o Contato!"));
		}
		return null;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public List<Contato> getContatos() {
		if(contatos == null) {
			contatos = ContatoDao.listar();
		}		
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
