package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.Alfil;
import Entidades.Caballo;
import Entidades.Peon;
import Entidades.Reina;
import Entidades.Rey;
import Entidades.Torre;

/**
 * Servlet implementation class ServletMovimiento
 */
@WebServlet("/ServletMovimiento")
public class ServletMovimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Peon> peones=new ArrayList<Peon>();
	ArrayList<Alfil> alfiles=new ArrayList<Alfil>();
	ArrayList<Caballo> caballos=new ArrayList<Caballo>();
	ArrayList<Reina> reinas=new ArrayList<Reina>();
	ArrayList<Rey> reyes=new ArrayList<Rey>();
	ArrayList<Torre> torres=new ArrayList<Torre>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMovimiento() {
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
		int filaActual=Integer.parseInt(request.getParameter("filaActual"));
		int filaProx=Integer.parseInt(request.getParameter("filaProx"));
		int columnaActual=Integer.parseInt(request.getParameter("columnaActual"));
		int columnaProx=Integer.parseInt(request.getParameter("columnaProx"));
		peones=(ArrayList<Peon>)request.getSession().getAttribute("peones");
		torres=(ArrayList<Torre>)request.getSession().getAttribute("torres");
		alfiles=(ArrayList<Alfil>)request.getSession().getAttribute("alfiles");
		caballos=(ArrayList<Caballo>)request.getSession().getAttribute("caballos");
		reyes=(ArrayList<Rey>)request.getSession().getAttribute("reyes");
		reinas=(ArrayList<Reina>)request.getSession().getAttribute("reinas");
		
		actualizarTablero(filaActual,columnaActual,filaProx,columnaProx);
	}
	
	public void actualizarTablero(int filaActual,int columnaActual,int filaProxima,int columnaProxima){
    	int x=0;
    	boolean ban_pieza=true;
    	while(x<16)
    	{
    		
    		if(peones.get(x).getFila()==filaActual && peones.get(x).getColumna()==columnaActual && peones.get(x).isState())
    		{
    			
    			ban_pieza=false;
    			if(peones.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
    			{
    				comerficha(filaProxima,columnaProxima);
    				System.out.print("PeonEntro");
    				peones.get(x).setFila(filaProxima);
    				peones.get(x).setColumna(columnaProxima);
    					 				
    			}			
    		}
    		x++;
    	}
    	x=0;
    	
    	if(ban_pieza)
    	{
    		while( x<4)
	    	{
	    		if(torres.get(x).getFila()==filaActual && torres.get(x).getColumna()==columnaActual && torres.get(x).isState())
	    		{
	    			System.out.print("Torre");
	    			ban_pieza=false;
	    			if(torres.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("TorreEntro");
	    				torres.get(x).setFila(filaProxima);
	    				torres.get(x).setColumna(columnaProxima);
	    				
	    			}			
	    		}
	    		x++;
	    	}
    		
    	}
    	
    	x=0;
    	
    	if(ban_pieza)
    	{
    		while( x<4)
	    	{
	    		if(caballos.get(x).getFila()==filaActual && caballos.get(x).getColumna()==columnaActual && caballos.get(x).isState())
	    		{
	    			System.out.print("caballos");
	    			ban_pieza=false;
	    			if(caballos.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("caballosEntro");
	    				caballos.get(x).setFila(filaProxima);
	    				caballos.get(x).setColumna(columnaProxima);
	    					
	    			}			
	    		}
	    		x++;
	    	}
    		
    	}
    	x=0;
    	
    	if(ban_pieza)
    	{
    		while( x<4)
	    	{
	    		if(alfiles.get(x).getFila()==filaActual && alfiles.get(x).getColumna()==columnaActual && alfiles.get(x).isState())
	    		{
	    			System.out.print("alfiles");
	    			ban_pieza=false;
	    			if(alfiles.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("alfilesEntro");
	    				alfiles.get(x).setFila(filaProxima);
	    				alfiles.get(x).setColumna(columnaProxima);
	    				 				
	    			}			
	    		}
	    		x++;
	    	}
    		
    	}
    	x=0;
    	
    	if(ban_pieza)
    	{
    		while( x<2)
	    	{
	    		if(reyes.get(x).getFila()==filaActual && reyes.get(x).getColumna()==columnaActual && reyes.get(x).isState())
	    		{
	    			System.out.print("reyes");
	    			ban_pieza=false;
	    			if(reyes.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("reyesEntro");
	    				reyes.get(x).setFila(filaProxima);
	    				reyes.get(x).setColumna(columnaProxima);
	    				 				
	    			}			
	    		}
	    		x++;
	    	}
    		
    	}
    	x=0;
    	
    	if(ban_pieza)
    	{
    		while( x<2)
	    	{
	    		if(reinas.get(x).getFila()==filaActual && reinas.get(x).getColumna()==columnaActual && reinas.get(x).isState())
	    		{
	    			System.out.print("reinas");
	    			ban_pieza=false;
	    			if(reinas.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("reyesEntro");
	    				reinas.get(x).setFila(filaProxima);
	    				reinas.get(x).setColumna(columnaProxima);
	    								
	    			}
	    			
	    		}
	    		x++;
	    	}

    	}
  
  }
	
	 private void comerficha(int filaProxima,int columnaProxima){
	    	int x=0;
	    	while(x<16)
	    	{
	    		if(peones.get(x).getFila()==filaProxima && peones.get(x).getColumna()==columnaProxima && peones.get(x).isState())
	    		{
	    		
	    				peones.get(x).setState(false);		 				
	    		}	
	    		x++;
	    	}
	    	x=0;
	    	while(x<4)
	    	{
	    		if(torres.get(x).getFila()==filaProxima && torres.get(x).getColumna()==columnaProxima && torres.get(x).isState())
	    		{
	    				torres.get(x).setState(false);		 				
	    		}
	    		if(caballos.get(x).getFila()==filaProxima && caballos.get(x).getColumna()==columnaProxima && caballos.get(x).isState())
	    		{
	    				caballos.get(x).setState(false);		 				
	    		}
	    		if(alfiles.get(x).getFila()==filaProxima && alfiles.get(x).getColumna()==columnaProxima && alfiles.get(x).isState())
	    		{
	    				alfiles.get(x).setState(false);		 				
	    		}
	    		x++;
	    	}
	    	x=0;
	    	while(x<2)
	    	{
	    		if(reyes.get(x).getFila()==filaProxima && reyes.get(x).getColumna()==columnaProxima && reyes.get(x).isState())
	    		{
	    				reyes.get(x).setState(false);		 				
	    		}
	    		if(reinas.get(x).getFila()==filaProxima && reinas.get(x).getColumna()==columnaProxima && reinas.get(x).isState())
	    		{
	    				reinas.get(x).setState(false);		 				
	    		}
	    		
	    		x++;
	    	}
	    		
	    }
	    

}
