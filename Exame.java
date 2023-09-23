package Examepoo;

public class Exame {
	private int idExame;
	private String nomePaciente;
	private int nivelGlicose;

	public Exame(int idExame, String nomePaciente, int nivelGlicose) {
		this.idExame = idExame;
		this.nomePaciente = nomePaciente;
		this.nivelGlicose = nivelGlicose;
	}

	public int getIdExame() {
		return idExame;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public int getNivelGlicose() {
		return nivelGlicose;
	}

	public void setNivelGlicose(int nivelGlicose) {
		this.nivelGlicose = nivelGlicose;
	}

	public String obterDiagnostico() {
		if (this.nivelGlicose <= 99) {
			return "normal";
		} else if (this.nivelGlicose <= 125) {
			return "Pré-diabetes";
		} else {
			return "diabetes";
		}
	}
}