package ut01.xml;

import java.io.Serializable;


public class Disco implements Serializable {
		

	private static final long serialVersionUID = 1L;
	
		enum Formato {MP3, CD, OGG};
		String titulo;
		Formato formato;
		String autor;
		
		public Disco() {
		
		}
		
		public Disco(String titulo, Formato formato, String autor) {
			this.titulo = titulo;
			this.formato = formato;
			this.autor = autor;
		}
		public String getTitulo() {
			return titulo;
		}
		public Formato getFormato() {
			return formato;
		}
		public String getAutor() {
			return autor;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public void setFormato(Formato formato) {
			this.formato = formato;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}

		@Override
		public String toString() {
			return "Disco [titulo=" + titulo + ", formato=" + formato
					+ ", autor=" + autor + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((autor == null) ? 0 : autor.hashCode());
			result = prime * result
					+ ((formato == null) ? 0 : formato.hashCode());
			result = prime * result
					+ ((titulo == null) ? 0 : titulo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Disco other = (Disco) obj;
			if (autor == null) {
				if (other.autor != null)
					return false;
			} else if (!autor.equals(other.autor))
				return false;
			if (formato != other.formato)
				return false;
			if (titulo == null) {
				if (other.titulo != null)
					return false;
			} else if (!titulo.equals(other.titulo))
				return false;
			return true;
		}
		
		
		
		
	}


