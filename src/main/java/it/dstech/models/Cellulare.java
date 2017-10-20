package it.dstech.models;

public class Cellulare {
private int id;

private String marca;

private String modello;

private int prezzo;

private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModello() {
	return modello;
}

public void setModello(String modello) {
	this.modello = modello;
}

public int getPrezzo() {
	return prezzo;
}

public void setPrezzo(int prezzo) {
	this.prezzo = prezzo;
}

@Override
public String toString() {
	return "Cellulare [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo + "]";
}


}
