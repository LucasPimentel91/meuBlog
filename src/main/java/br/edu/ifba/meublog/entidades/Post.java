package br.edu.ifba.meublog.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="posts") 
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String titulo;
   private String texto;
   @ManyToOne
   private Usuario usuario;
   @Enumerated(EnumType.STRING)
   private Categoria categoria = Categoria.POLITICA;
   
   public Post(Long id, String titulo, String texto, Usuario usuario, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.categoria = categoria;
	}
}
