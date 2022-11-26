import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	//Variables
	private JPanel contentPane;
	private JTextField cajaTexto;
	private JButton bUno, bDos, bTres, bCuatro, bCinco, bSeis, bSiete, bOcho, bNueve, bCero;
	private JButton bBorrar, bPar, bIgual, bSuma, bResta, bMultiplicacion, bDivision;
	private String primerNumero = "", segundoNumero = "", operacion = "";
	private int contador = 0, primero = 0, segundo = 0, resultado = 0;
	private double primeroD = 0.0f, segundoD = 0.0f, resultadoD = 0.0f;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setBackground(new Color(220, 220, 220));
		setTitle("Calculadora");
		setFont(new Font("Calibri Light", Font.BOLD, 12));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/Iconos/calculator_icon-icons.com_72046.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Boton C al pulsarlo se desbloquea todo
		bBorrar = new JButton("C");
		bBorrar.setBounds(21, 71, 45, 45);
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetear();
				cajaTexto.setText("");
				desbloqueo();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(bBorrar);
		
		//Boton Par
		bPar = new JButton("Par");
		bPar.setBounds(76, 71, 68, 45);
		bPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Si el primer numero esta vacio bloquea todo y muestra: Error
				if(primerNumero == "") {
					bloqueo();
					cajaTexto.setBackground(Color.red);
					cajaTexto.setText("Error");
				}
				//En caso contrario muestra si es par o impar y bloquea todas las teclas
				else {
				numeroPar();
				bloqueo();
				}
			}
		});
		contentPane.add(bPar);
		
		//Boton uno, al pulsarlo muestra un 1 en pantalla
		bUno = new JButton("1");
		bUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="1";
					cajaTexto.setText(segundoNumero);
				}
				else {
					primerNumero+= "1";
					cajaTexto.setText(primerNumero);
				}
			}
		});
		bUno.setBounds(21, 124, 45, 45);
		contentPane.add(bUno);
		
		//Boton dos, al pulsarlo muestra un 2 en pantalla
		bDos = new JButton("2");
		bDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="2";
					cajaTexto.setText(segundoNumero);
				}
				else {
					primerNumero+= "2";
					cajaTexto.setText(primerNumero);
				}
			}
		});
		bDos.setBounds(76, 124, 45, 45);
		contentPane.add(bDos);
		
		//Boton tres, al pulsarlo muestra un 3 en pantalla
		bTres = new JButton("3");
		bTres.setBounds(131, 124, 45, 45);
		bTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="3";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "3";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bTres);
		
		//Boton cuatro, al pulsarlo muestra un 4 en pantalla
		bCuatro = new JButton("4");
		bCuatro.setBounds(21, 180, 45, 45);
		bCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="4";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "4";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bCuatro);
		
		
		//Boton cinco, al pulsarlo muestra un 5 en pantalla
		bCinco = new JButton("5");
		bCinco.setBounds(76, 180, 45, 45);
		bCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="5";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "5";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bCinco);
		
		//Boton seis, al pulsarlo muestra un 6 en pantalla
		bSeis = new JButton("6");
		bSeis.setBounds(131, 180, 45, 45);
		bSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="6";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "6";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bSeis);
		
		//Boton siete, al pulsarlo muestra un 7 en pantalla
		bSiete = new JButton("7");
		bSiete.setBounds(21, 236, 45, 45);
		bSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="7";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "7";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bSiete);
		
		//Boton ocho, al pulsarlo muestra un 8 en pantalla
		bOcho = new JButton("8");
		bOcho.setBounds(76, 236, 45, 45);
		bOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="8";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "8";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bOcho);
		
		//Boton nueve, al pulsarlo muestra un 9 en pantalla
		bNueve = new JButton("9");
		bNueve.setBounds(131, 236, 45, 45);
		bNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="9";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "9";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bNueve);
		
		//Boton cero, al pulsarlo muestra un 0 en pantalla
		bCero = new JButton("0");
		bCero.setBounds(21, 292, 45, 45);
		bCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contador > 0) {
					segundoNumero+="0";
					cajaTexto.setText(segundoNumero);
				}
				else {
				primerNumero+= "0";
				cajaTexto.setText(primerNumero);
			}
			}
		});
		contentPane.add(bCero);
		
		//Boton del igual
		bIgual = new JButton("=");
		bIgual.setBounds(76, 292, 100, 45);
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Si el segundo numero es menor o igual a 0 muestra indeterminacion en pantalla
				if (operacion == "/" && segundoNumero.equals("0")) {
					bloqueo();
					cajaTexto.setText("Indeterminacion");
				}
				//Si el primer numero esta vacio o el segundo numero es vacio y la caja de texto esta vacia bloquea todo menos C
				else if(primerNumero == "" || cajaTexto.getText() != "" && segundoNumero == "") {
					bloqueo();
					cajaTexto.setBackground(Color.red);
					cajaTexto.setText("Error");
				}
				//Si el numero es mas largo de 10 hace la operacion con double
				else if (primerNumero.length() >= 10 || segundoNumero.length() >= 10) {
					operacionesDouble();
				}
				//En el else se ejecuta todo lo demas, si al dar resultado se pulsa otro numero 
				else {
					operaciones();
					bloqueo();
				}
			}
		});
		
		contentPane.add(bIgual);
		
		//boton de la suma, al pulsarlo suma, si se pulsa sin tener ningun numero da error
		bSuma = new JButton("+");
		bSuma.setBounds(209, 124, 45, 45);
		
		bSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = "+";
				opVacia();
			}
		});
		contentPane.add(bSuma);
		
		//boton de la resta, al pulsarlo resta, si se pulsa sin tener ningun numero da error
		bResta = new JButton("-");
		bResta.setBounds(209, 180, 45, 45);
		bResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = "-";
				opVacia();
			}
		});
		contentPane.add(bResta);
		
		//boton de la multiplicacion, al pulsarlo multiplica, si se pulsa sin tener ningun numero da error
		bMultiplicacion = new JButton("*");
		bMultiplicacion.setBounds(209, 236, 45, 45);
		bMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = "*";
				opVacia();
			}
		});
		contentPane.add(bMultiplicacion);
		
		//boton de la division, al pulsarlo divide, si se pulsa sin tener ningun numero da error
		bDivision = new JButton("/");
		bDivision.setBounds(209, 292, 45, 45);
		bDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacion = "/";
				opVacia();
			}
		});
		contentPane.add(bDivision);
		
		//Caja texto, hacemos que no se pueda modificar. Mostrara toda la info de lo que hacemos
		cajaTexto = new JTextField();
		cajaTexto.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		cajaTexto.setBackground(new Color(255, 255, 255));
		cajaTexto.setEditable(false);
		cajaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		cajaTexto.setBounds(21, 11, 233, 49);
		contentPane.add(cajaTexto);
		cajaTexto.setColumns(10);
	}
	
	//Funcion que bloquea todos los botones
	public void bloqueo() {
		bSuma.setEnabled(false);
		bResta.setEnabled(false);
		bMultiplicacion.setEnabled(false);
		bDivision.setEnabled(false);
		bUno.setEnabled(false);
		bDos.setEnabled(false);
		bTres.setEnabled(false);
		bCuatro.setEnabled(false);
		bCinco.setEnabled(false);
		bSeis.setEnabled(false);
		bSiete.setEnabled(false);
		bOcho.setEnabled(false);
		bNueve.setEnabled(false);
		bCero.setEnabled(false);
		bPar.setEnabled(false);
		bIgual.setEnabled(false);
	}
	//Funcion que bloquea los botones de operaciones
	public void bloqueoOp() {
		bSuma.setEnabled(false);
		bResta.setEnabled(false);
		bMultiplicacion.setEnabled(false);
		bDivision.setEnabled(false);
		bPar.setEnabled(false);
	}
	
	//Funcion que desbloquea todos los botones
	public void desbloqueo() {
		bSuma.setEnabled(true);
		bResta.setEnabled(true);
		bMultiplicacion.setEnabled(true);
		bDivision.setEnabled(true);
		bUno.setEnabled(true);
		bDos.setEnabled(true);
		bTres.setEnabled(true);
		bCuatro.setEnabled(true);
		bCinco.setEnabled(true);
		bSeis.setEnabled(true);
		bSiete.setEnabled(true);
		bOcho.setEnabled(true);
		bNueve.setEnabled(true);
		bCero.setEnabled(true);
		bPar.setEnabled(true);
		bIgual.setEnabled(true);
	}
	//Funcion que realiza las operaciones y muestra el resultado por pantalla
	public void operaciones() {
		primero = Integer.valueOf(primerNumero);
		segundo = Integer.valueOf(segundoNumero);
		
			if(operacion == "/") {
			Float primero = Float.valueOf(primerNumero);
			Float segundo = Float.valueOf(segundoNumero);
			float resultado = primero / segundo;
			String texto = Float.toString(resultado);
			cajaTexto.setText(texto);
			}
			else {
				if(operacion == "+") {
					resultado = primero + segundo;
				}
				else if(operacion == "-") {
					resultado = primero - segundo;
				}
					
				else if(operacion == "*") {
					resultado = primero * segundo;
				}
				String texto = Integer.toString(resultado);
				cajaTexto.setText(texto);
			}
		}
	//Funcion que realiza las operaciones con un double y muestra el resultado por pantalla
	public void operacionesDouble() {
		primeroD = Double.parseDouble(primerNumero);
		segundoD = Double.parseDouble(segundoNumero);
		if(operacion == "+") {
			resultadoD = primeroD + segundoD;
		}
		else if(operacion == "-") {
			resultadoD = primeroD - segundoD;
		}
		else if(operacion == "*") {
			resultadoD = primeroD * segundoD;
		}
		else if(operacion == "/") {
			resultadoD = primeroD / segundoD;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		String texto = String.valueOf(df.format(resultadoD));
		cajaTexto.setText(texto);
	}
	//Funcion que devuelve los valores a sus valores iniciales
	public void resetear() {
		primerNumero = "";
		segundoNumero = "";
		operacion = "";
		contador = 0;
		cajaTexto.setBackground(Color.white);;
	}
	//Funcion que almacena el primer numero y suma al contador
	public void almacenaje() {
		primerNumero = cajaTexto.getText();
		cajaTexto.setText("");
		contador+=1;
	}
	//Funcion que calcula si un numero es par o impar
	public void numeroPar() {
		primero = Integer.valueOf(primerNumero);
		if (primero % 2 == 0 && primero  >= 2) {
			
			cajaTexto.setText("Par");
		}
		else {
			cajaTexto.setText("Impar");
		}
		primerNumero = "";
	}
	//Funcion de las operaciones, si esta vacio el primero se bloquea
	public void op() {
		if(primerNumero == "") {
			bloqueo();
		}
		else {
		almacenaje();
		}
		
	
	}
	//Si la operacion esta vacia se bloquea todo y muestra mensaje de error, en caso contrario hace operacion
	public void opVacia() {
		if(primerNumero == "") {
			bloqueo();
			cajaTexto.setBackground(Color.red);
			cajaTexto.setText("Error");
		}
		else {
			bloqueoOp();
			op();
		}
		
	}
}
