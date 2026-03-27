import com.ferbo.gestion.core.dao.AsentamientoDAO;
import com.ferbo.gestion.core.dao.CiudadDAO;
import com.ferbo.gestion.core.dao.ClienteDAO;
import com.ferbo.gestion.core.dao.AvisoDAO;
import com.ferbo.gestion.core.dao.CategoriaDAO;
import com.ferbo.gestion.core.dao.ClienteContactoDAO;
import com.ferbo.gestion.core.dao.ClienteDomicilioDAO;
import com.ferbo.gestion.core.dao.ConstanciaDepositoDAO;
import com.ferbo.gestion.core.dao.ConstanciaSalidaDAO;
import com.ferbo.gestion.core.dao.FacturaDAO;
import com.ferbo.gestion.core.dao.FacturacionDepositosDAO;
import com.ferbo.gestion.core.dao.FacturacionServiciosDAO;
import com.ferbo.gestion.core.dao.FacturacionVigenciasDAO;
import com.ferbo.gestion.core.model.Asentamiento;
import com.ferbo.gestion.core.model.Aviso;
import com.ferbo.gestion.core.model.Categoria;
import com.ferbo.gestion.core.model.Ciudad;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.model.ClienteDomicilio;
import com.ferbo.gestion.core.model.ConstanciaDeposito;
import com.ferbo.gestion.core.model.ConstanciaFactura;
import com.ferbo.gestion.core.model.ConstanciaFacturaDs;
import com.ferbo.gestion.core.model.ConstanciaSalida;
import com.ferbo.gestion.core.model.Factura;
import com.ferbo.gestion.core.tools.CoreException;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main 
{
    private static Logger log = LogManager.getLogger(Main.class);
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static AsentamientoDAO asentamientoDAO = new AsentamientoDAO();
    private static CiudadDAO ciudadDAO = new CiudadDAO();
    private static AvisoDAO avisoDAO = new AvisoDAO();
    private static CategoriaDAO categoriaDAO = new CategoriaDAO();
    private static ClienteContactoDAO clienteContactoDAO = new ClienteContactoDAO(); 
    private static ClienteDomicilioDAO clienteDomicilioDAO = new ClienteDomicilioDAO(); 
    private static ConstanciaDepositoDAO constanciaDepositoDAO = new ConstanciaDepositoDAO();
    private static ConstanciaSalidaDAO constanciaSalidaDAO = new ConstanciaSalidaDAO();
    private static FacturaDAO facturaDAO = new FacturaDAO();
    private static FacturacionDepositosDAO facturacionDepositosDAO = new FacturacionDepositosDAO();
    private static FacturacionServiciosDAO facturacionServiciosDAO = new FacturacionServiciosDAO();
    private static FacturacionVigenciasDAO facturacionVigenciasDAO = new FacturacionVigenciasDAO();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Cliente cliente = clienteDAO.obtenerPorId(6);
            log.info(cliente.toString());

            List<Asentamiento> listAsentamiento = asentamientoDAO.buscaPorCP("09040");
            for(Asentamiento aux : listAsentamiento){
                log.info(aux.toString());
            }

            List<Ciudad> ciudades = ciudadDAO.buscarPorParametros(0, 10, 1, 150);
            for(Ciudad aux : ciudades){
                log.info(aux.toString());
            }
        
            List<Aviso> avisos = avisoDAO.buscarPorCliente(12);
            for(Aviso aux : avisos){
                log.info(aux.toString());
            }
            
            List<Categoria> categorias = categoriaDAO.buscarTodos();
            for(Categoria aux : categorias){
                log.info(aux.toString());
            }
            
            List<ClienteContacto> contactosCliente = clienteContactoDAO.obtenerPorIdCliente(cliente);
            for(ClienteContacto aux : contactosCliente){
                log.info(aux.toString());
            }
            
            List<ClienteDomicilio> clientesDomicilios = clienteDomicilioDAO.buscarDomicilioFiscalPorCliente(cliente.getId(), true);
            for(ClienteDomicilio aux : clientesDomicilios){
                log.info(aux.toString());
            }
            
            ConstanciaDeposito constanciaDeposito = constanciaDepositoDAO.buscarPorFolioCliente("B 434");
            log.info(constanciaDeposito.toString());
            
            List<ConstanciaSalida> constanciasSalidas = constanciaSalidaDAO.obtenerPorFolioDeposito(constanciaDeposito.getFolio());
            for(ConstanciaSalida aux : constanciasSalidas){
                log.info(aux.toString());
            }
            
            String fechaInicial = "2022-01-01";
            LocalDate fechaInicio = LocalDate.parse(fechaInicial);
            
            String fechaFinal = "2026-03-24";
            LocalDate fechaFin = LocalDate.parse(fechaFinal);
            
            /*List<Factura> facturas = facturaDAO.buscaFacturas(cliente, fechaInicio, fechaFin, true);
            for(Factura aux : facturas){
                log.info(aux.toString());
            }*/
            
            List<ConstanciaFactura> nofacturadosCliente6 = facturacionDepositosDAO.buscarNoFacturados(cliente.getId(), 1);
            for(ConstanciaFactura aux : nofacturadosCliente6){
                log.info(aux.toString());
            }
            
            List<ConstanciaFacturaDs> noServiciosFacturadosCliente6 = facturacionServiciosDAO.buscarNoFacturados(cliente.getId());
            for(ConstanciaFacturaDs aux : noServiciosFacturadosCliente6){
                log.info(aux.toString());
            }
            
            List<ConstanciaFactura> noVigenciasFacturadasCliente6 = facturacionVigenciasDAO.buscarNoFacturados(cliente.getId(), fechaFin, 1);
            for(ConstanciaFactura aux : noVigenciasFacturadasCliente6){
                log.info(aux.toString());
            }
            
            
        } catch(CoreException ex){
            log.info(ex.getMessage());
        }
    }
    
}
