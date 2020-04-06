/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.AsesorDAO;
import DAOs.ClienteDAO;
import DAOs.ContratoDAO;
import DAOs.InmuebleDAO;
import DAOs.PagoAlquilerDAO;
import Modelo.Asesor;
import Modelo.Cliente;
import Modelo.Contrato;
import Vistas.HacerContratoView;

/**
 *
 * @author fran_
 */
public class HacerContratoController {

    private HacerContratoView view = null;

    public HacerContratoController(HacerContratoView view) {
        this.view = view;
    }

    /**
     * Recibe un contrato nuevo por parametro lo da de alta en la base de datos
     * retorna verdadero si el alta fue exitosa
     *
     * @param nuevo
     * @return
     */
    public void alta2(Contrato nuevo) {
        System.out.println("Hasta aca llegue");
        (new ContratoDAO()).alta(nuevo);
        view.respuestaAlta(0);
    }

    /**
     * Recibe un contrato nuevo por parametro lo da de alta en la base de datos     *
     * @param nuevo
     */
    public void alta(Contrato nuevo, float senia, float precioInicial, int periodo) {
        if ((new ContratoDAO()).alta(nuevo)) {
            if ((new PagoAlquilerDAO()).altaNpagos(nuevo, senia, precioInicial, periodo)) {
                view.respuestaAlta(0);
            } else {
                view.respuestaAlta(2);
            }
        } else {
            view.respuestaAlta(1);
        }
    }

    /**
     * Setea la vista donde trabajara el controlador
     *
     * @param vista
     */
    public void setVista(HacerContratoView vista) {
        this.view = vista;
    }

    /**
     * Recibe el dni del cliente por parametro Crea una lista de clientes que
     * empiezen con ese dni Le pasa esa lista al view para que llene la tabla de
     * clientes
     *
     * @param dni
     */
    public void llenarTablaPorDni(String dni) {
        view.llenarTablaClientes((new ClienteDAO()).listarPorDNI(dni));
    }

    public Cliente buscarCliente(int id) {
        return (new ClienteDAO()).buscar(id);
    }

    public Asesor buscarAsesor(int id) {
        return (new AsesorDAO()).buscar(id);
    }

    public void llenarComboBox() {
        view.llenarAsesores((new AsesorDAO()).listarTodo());
    }

    public void setReservado(int id) {
        (new InmuebleDAO()).setEstado(id, 3);
    }

    public void altaCliente(Cliente nuevo) {
        (new ClienteDAO()).alta(nuevo);
    }

}
