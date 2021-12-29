package application;

public class User {
private Integer ID;
private String Fio;
private String dolznost;
private String log;
private String pas;

public User (Integer ID,String Fio, String dolznost , String log, String pas) {
	this.ID =ID;
	this.Fio =Fio;
	this.dolznost =dolznost;
	this.log =log;
	this.pas =pas;
}
 public User() {
	
}
public Integer getID() {
	 return ID;
 }
 public void setID(Integer ID) {
	 this.ID=ID;
 }
 public String getFio() {
	 return Fio;
 }
 public void setFio(String Fio) {
	 this.Fio=Fio;
 }
 public String getdolznost() {
	 return dolznost;
 }
 public void setdolznost(String dolznost) {
	 this.dolznost=dolznost;
 }
 public String getlog() {
	 return log;
 }
 public void setlog(String log) {
	 this.log=log;
 }
 public String getpas() {
	 return pas;
 }
 public void setpas(String pas) {
	 this.pas=pas;
 }
}
