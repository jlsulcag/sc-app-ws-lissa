package com.sulcacorp.lissa.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel(description = "Informacion de Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONA")
public class Persona {
	@Id
	@Column(name = "ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PERSONA", nullable = false, foreignKey = @ForeignKey(name="fk_persona_tipopersona"))
	private TipoPersona tipoPersona;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENTIDAD", nullable = false, foreignKey = @ForeignKey(name="fk_persona_tipodocumento_identidad"))
	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO_CIVIL", nullable = false, foreignKey = @ForeignKey(name="fk_persona_estadocivil"))
	private EstadoCivil estadoCivil;
	
	@Column(name = "NOMBRES", nullable = false, length = 100)
	private String nombres;
	
	@Column(name = "APELLIDO_PATERNO", nullable = false, length = 100)
	private String apellidoPaterno;
	
	@Column(name = "APELLIDO_MATERNO", nullable = false, length = 100)
	private String apellidoMaterno;
	
	@ApiModelProperty(notes = "Numero de Documento debe tener minimo 8 caracteres")
	@Size(min = 8, message = "Numero de Documento debe tener minimo 8 caracteres")
	@Column(name = "NUMERO_DOCUMENTO_IDENTIDAD", nullable = false, length = 25)
	private String numeroDocumentoIdentidad;
	
	@Column(name = "FECHA_NACIMIENTO", nullable = true)
	private LocalDate fechaNacimiento;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDate fechaRegistro;
	
	@Column(name = "SEXO", nullable = true, length = 2)
	private String sexo;
	
	@Column(name = "DIRECCION", nullable = true, length = 200)
	private String direccion;
	
	@Column(name = "TELEFONO", nullable = true, length = 40)
	private String telefono;
	
	@Column(name = "CORREO_ELECTRONICO", nullable = true, length = 50)
	private String correoElectronico;
	
	@Column(name = "LUGAR_NACIMIENTO", nullable = true, length = 100)
	private String lugarNacimiento;
	
	@Column(name = "LUGAR_PROCEDENCIA", nullable = true, length = 100)
	private String lugarProcedencia;
	
	@Column(name = "GRADO_INSTRUCCION", nullable = true, length = 100)
	private String gradoInstruccion;
	
	@Column(name = "OCUPACION", nullable = true, length = 100)
	private String ocupacion;
	
	@Column(name = "ES_PROVEEDOR", nullable = false)
	private int esProveedor;
	
	@Column(name = "ESTADO", nullable = false)
	private int estado = 1;
	
}
