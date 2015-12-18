package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.*;
import Negocio.JugadorLogic;

/**
 * Servlet implementation class ServletLoginJugadores
 */
@WebServlet("/ServletLoginJugadores")
public class ServletLoginJugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Peon> peones=new ArrayList<Peon>();
	ArrayList<Alfil> alfiles=new ArrayList<Alfil>();
	ArrayList<Caballo> caballos=new ArrayList<Caballo>();
	ArrayList<Reina> reinas=new ArrayList<Reina>();
	ArrayList<Rey> reyes=new ArrayList<Rey>();
	ArrayList<Torre> torres=new ArrayList<Torre>();
	Partida partida=new Partida();
	ArrayList<Jugador> jug= new ArrayList<Jugador>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoginJugadores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni1=Integer.parseInt(request.getParameter("dni1"));
		int dni2=Integer.parseInt(request.getParameter("dni2"));
		
		
		JugadorLogic jl=new JugadorLogic();
		jug.add(jl.getJugador(dni1));
		jug.add(jl.getJugador(dni2));
		System.out.println(jug.get(0).getApellido());
		
		boolean ban=false;
		if(jug.size()!=2){
			request.getSession().setAttribute("JugadoresLogueados", ban);
			response.sendRedirect("LoginJugadores.html");
		} else {
			
			getTableroInicial();
			request.getSession().setAttribute("peones",peones);
			request.getSession().setAttribute("torres",torres);
			request.getSession().setAttribute("caballos",caballos);
			request.getSession().setAttribute("alfiles",alfiles);
			request.getSession().setAttribute("reyes",reyes);
			request.getSession().setAttribute("reinas",reinas);
			request.getSession().setAttribute("JugadoresLogueados", jug);
			response.sendRedirect("Tablero.jsp");
		}
		
	}

	 public void getTableroInicial()
	    {	
	    	//int idNueva=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el id de la partida a crear: ",JOptionPane.INFORMATION_MESSAGE));
		 int idNueva=1;
		 partida.setId(idNueva);
	    	partida.setJ1(jug.get(0).getDni());
	    	partida.setJ2(jug.get(1).getDni());
	    	
	    	for(int i=0;i<16;i++){
	    		Peon p=new Peon();
	    		p.setId(i);
	    		if(i<8){
	    		p.setColor("Blanco");
	    		p.setFila(1);
	    		p.setColumna(i);
	    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(6);
	    		p.setColumna(i-8);}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		peones.add(p);
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Alfil p=new Alfil();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(2);}
	    		if(i==1)
	    		{p.setColumna(5);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(2);}
	    		if(i==3)
	    		{p.setColumna(5);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		alfiles.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Caballo p=new Caballo();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(1);}
	    		if(i==1)
	    		{p.setColumna(6);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(1);}
	    		if(i==3)
	    		{p.setColumna(6);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		caballos.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Torre p=new Torre();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(0);}
	    		if(i==1)
	    		{p.setColumna(7);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(0);}
	    		if(i==3)
	    		{p.setColumna(7);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		torres.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<2;i++){
	    		Rey p=new Rey();
	    		p.setId(i);
	    		if(i<1){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		p.setColumna(3);	
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		p.setColumna(3);
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		reyes.add(p);
	    		
	    		
	    	}
	    	
	    	for(int i=0;i<2;i++){
	    		Reina p=new Reina();
	    		p.setId(i);
	    		if(i<1){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		p.setColumna(4);	
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		p.setColumna(4);
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		reinas.add(p);
	    		
	    		
	    	}
	    	
	    	
	    }
	    
}
